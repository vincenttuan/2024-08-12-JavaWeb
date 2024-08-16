package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 取得?name=xxx&height=xxx&weight=xxx參數
			String name = req.getParameter("name");
			double height = Double.parseDouble(req.getParameter("height"));
			double weight = Double.parseDouble(req.getParameter("weight"));
			// 計算與印出 bmi 資訊
			calcBmiAndPrint(name, height, weight, resp);
		} catch (Exception e) {
			resp.getWriter().print("Please input parameter.");
		}
	}
	
	// 計算 bmi 與透過 resp 印出 bmi 資訊
	private void calcBmiAndPrint(String name, double height, double weight, HttpServletResponse resp) {
		
	}
	
	
}
