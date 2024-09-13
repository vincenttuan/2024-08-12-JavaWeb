package login.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.entity.User;
import login.service.UserService;

@WebServlet("/user/list")
public class UserServlet extends HttpServlet {
	// 取得 UserService 的實體物件
	private UserService userService = UserService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到所有使用者資料
		List<User> users = userService.findAllUsers();
		// 將 users 放到 request 物件屬性中, 以便傳給 user.jsp 使用
		req.setAttribute("users", users);
		// 傳送到 user.jsp
		req.getRequestDispatcher("/WEB-INF/jsp/login/user.jsp").forward(req, resp);
	}
	
}
