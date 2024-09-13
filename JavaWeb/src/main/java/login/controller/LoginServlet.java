package login.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 使用者登入
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到指定 login.jsp 表單畫面
		req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, resp);
	}
	
}
