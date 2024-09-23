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

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	private ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductDto> productDtos = productService.findAllProducts();
		req.setAttribute("productDtos", productDtos);
		req.getRequestDispatcher("/WEB-INF/jsp/login/product.jsp").forward(req, resp);
	}
	
	
}
