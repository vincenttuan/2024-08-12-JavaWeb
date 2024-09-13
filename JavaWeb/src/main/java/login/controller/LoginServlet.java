package login.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.dto.UserDto;
import login.exception.LoginException;
import login.service.UserService;

// 使用者登入
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	
	private UserService userService = UserService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到指定 login.jsp 表單畫面
		req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		// 比對登入資訊
		try {
			UserDto userDto = userService.verifyUser(userName, password);
			req.setAttribute("userDto", userDto);
			req.setAttribute("loginSuccess", true);
			req.setAttribute("loginMessage", "登入成功");
		} catch (LoginException e) {
			req.setAttribute("loginSuccess", false);
			req.setAttribute("loginMessage", "登入失敗");
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/login/login_result.jsp").forward(req, resp);
	}
	
}
