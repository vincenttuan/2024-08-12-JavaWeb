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
		Random random = new Random(); // 隨機數物件
		// 1~39 取 n 個不重複的號碼
		int n = 5;
		Set<Integer> lotto = new LinkedHashSet(); // 存放不重複的樂透號碼集合
		while (lotto.size() < n) {
			int number = random.nextInt(39) + 1;
			lotto.add(number);
		}
		// Response 回應
		resp.getWriter().print("Hello Lotto: " + lotto);
		
	}
	
}
