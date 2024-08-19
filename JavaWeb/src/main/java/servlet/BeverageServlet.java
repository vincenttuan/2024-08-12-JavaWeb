package servlet;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/beverage")
public class BeverageServlet extends HttpServlet {
	// 飲品名稱
	private Map<String, String> beverageNameMap = Map.of(
			"1", "奶茶", "2", "咖啡", "3", "紅茶", "4", "綠茶", "5", "清茶");
	// 飲品價格
	private Map<String, Integer> beveragePriceNameMap = Map.of(
			"1", 25, "2", 30, "3", 15, "4", 20, "5", 18);
	// 冷熱
	private Map<String, String> coldOrHotMap = Map.of("1", "冷", "2", "熱");
	// 配料名稱
	private Map<String, String> toppingMap = Map.of(
			"1", "珍珠", "2", "椰果", "3", "綠豆", "4", "芋園", "5", "薏仁");
	// 配料價格
	private Map<String, Integer> toppingPriceMap = Map.of(
			"1", 10, "2", 15, "3", 8, "4", 12, "5", 5);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 資料編碼
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
	}
	
}
