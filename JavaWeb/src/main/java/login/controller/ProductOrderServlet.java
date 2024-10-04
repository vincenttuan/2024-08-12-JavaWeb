package login.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.dto.ProductDto;
import login.service.ProductService;

@WebServlet("/product/order")
public class ProductOrderServlet extends HttpServlet {
	private ProductService productService = new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 商品資料
		List<ProductDto> products = productService.findAllProducts();
		// 將商品資料設定到 request attribute 給 jsp 取用
		req.setAttribute("products", products);
		// 重導到 product_order.jsp 商品訂購
		req.getRequestDispatcher("/WEB-INF/jsp/login/product_order.jsp").forward(req, resp);
	}
	
}
