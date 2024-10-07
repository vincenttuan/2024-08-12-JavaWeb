package login.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.exception.EmailConfirmException;
import login.service.UserService;

@WebServlet("/user/confirm/email")
public class ConfirmEmailServlet extends HttpServlet {
	private UserService userService = UserService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		boolean isPass = false;
		String errorMessage = "成功";
		try {
			isPass = userService.passEmail(userName);
		} catch (EmailConfirmException e) {
			errorMessage = e.getMessage();
		}
		
		req.setAttribute("isPass", isPass);
		req.setAttribute("errorMessage", errorMessage);
		req.getRequestDispatcher("/WEB-INF/jsp/login/confirm_email_result.jsp").forward(req, resp);
	}
	
}
