package login.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.dto.CartDto;
import login.service.ProductService;

@WebServlet("/product/cart")
public class ProductCartServlet extends HttpServlet {
	private ProductService productService = new ProductService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		// 將欲購買的商品放到 "cart" session 變數中
		HttpSession session = req.getSession();
		Map<Integer, CartDto> cart = null;
		if(session.getAttribute("cart") == null) {
			cart = new LinkedHashMap<>();
		} else {
			cart = (LinkedHashMap<Integer, CartDto>)session.getAttribute("cart");
		}
		
		CartDto cartDto = null;
		// 判斷 productId 是否已存在 cart 中
		if(cart.containsKey(productId)) {
			// 變更數量 amount
			cartDto = cart.get(productId);
			cartDto.setAmount(cartDto.getAmount() + amount); // 數量累加
		} else {
			// 建立 CartDto
			cartDto = new CartDto();
			cartDto.setProductId(productId);
			cartDto.setAmount(amount);
			cartDto.setProductDto(productService.getById(productId));
			// 將商品放入到 cart 中
			cart.put(productId, cartDto);
		}
		// 寫入到 session
		req.setAttribute("cart", cart);
		// 重導到 jsp 
	}
	
	
}
