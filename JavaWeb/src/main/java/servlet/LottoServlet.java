package servlet;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/lotto")
public class LottoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String countStr = req.getParameter("count"); // 取得 count 參數內容
		
		int count = 1; // 欲取得電腦選號的次數
		if(countStr != null && countStr.trim().length() > 0) { // countStr 不是 null , countStr 有內容 
			count = Integer.parseInt(countStr); // 字串轉數字
		}
		
		Random random = new Random(); // 隨機數物件
		
		resp.getWriter().print("<html>");
		for(int i=0;i<count;i++) {
			// 1~39 取 n 個不重複的號碼
			int n = 5;
			Set<Integer> lotto = new LinkedHashSet(); // 存放不重複的樂透號碼集合
			while (lotto.size() < n) {
				int number = random.nextInt(39) + 1;
				lotto.add(number);
			}
			// Response 回應
			//resp.getWriter().print("countStr: " + countStr);
			String color = i % 2 == 0 ? "blue" : "red";
			resp.getWriter().print("<div style='color: " + color + "'>");
			resp.getWriter().print("Lotto: " + lotto);
			resp.getWriter().print("</div>");
		}
		resp.getWriter().print("</html>");
	}
	
}
