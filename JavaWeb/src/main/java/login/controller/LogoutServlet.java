package login.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 登出
@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate(); // session 過期/失效
		
		// 利用外重導到 http://localhost:8080/JavaWeb/user/login 位置
		// 外重導: 可以指定任何對內或對外的網路位置, 並且重導的位置也會顯示在瀏覽器上
		//resp.sendRedirect("https://tw.yahoo.com");
		//resp.sendRedirect("http://localhost:8080/JavaWeb/user/login");
		resp.sendRedirect("/JavaWeb/user/login"); // 相當於 http://localhost:8080/JavaWeb/user/login
	}
	
}
