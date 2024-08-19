package servlet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/lucky", "/my/number"})
public class LuckyNumber extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int month = Integer.parseInt(req.getParameter("month"));
		int day = Integer.parseInt(req.getParameter("day"));
		
		// lucky number: month * day * dayOfMonth(今日日期) % 10
		LocalDate today = LocalDate.now();
		int dayOfMonth = today.getDayOfMonth();
		
		int number = month * day * dayOfMonth % 10;
		
		resp.getWriter().print("Your lucky number is " + number);
		
	}
	
	
}
