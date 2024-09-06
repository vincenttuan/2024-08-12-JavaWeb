package login.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.service.UserService;

// 使用者註冊
@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterServlet.class);
	
	private UserService userService = UserService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.接收使用者所傳的資料
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		// 將所收到的資料寫入 Log 以便日後 debug 或追蹤紀錄使用
		logger.info("userName: " + userName + ", password: " + password + ", email: " + email);
		
		// 透過 userService 將使用者資料加密並存入到資料表
		boolean checkResult = userService.insertUser(userName, password, email);
		logger.info("checkResult: " + checkResult);
		
		
	}
	
}
