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
import login.exception.ProductQtyNotEnoughException;
import login.service.ProductService;

@WebServlet("/product/cart")
public class ProductCartServlet extends HttpServlet {
	private ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到 jsp
		req.getRequestDispatcher("/WEB-INF/jsp/login/product_cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		// 取得購物車資料 "cart" session 變數中
		HttpSession session = req.getSession();
		Map<Integer, CartDto> cart = null;
		if(session.getAttribute("cart") == null) {
			cart = new LinkedHashMap<>();
		} else {
			cart = (LinkedHashMap<Integer, CartDto>)session.getAttribute("cart");
		}
		
		CartDto cartDto = null;
		int newAmount = amount;
		// 判斷 productId 是否已存在 cart 中
		if(cart.containsKey(productId)) {
			// 變更數量 amount
			cartDto = cart.get(productId);
			newAmount = cartDto.getAmount() + amount; // 數量累加
		} else {
			// 建立 CartDto
			cartDto = new CartDto();
			cartDto.setProductId(productId);
			cartDto.setProductDto(productService.getById(productId));
		}
		
		// 檢查商品庫存是否足夠
		int qty = productService.getById(productId).getQty(); // 目前商品庫存
		int previousAmount = cart.values()
								 .stream()
								 .filter(dto -> dto.getProductId() == productId)
								 .mapToInt(CartDto::getAmount).sum(); // 購物車中針對該商品已購買的數量
		System.out.println(cart + "," + previousAmount + ", " + amount);
		int totalAmount = previousAmount + amount;
		if(totalAmount > qty) { // 欲購買的數量 > 庫存
			try {
				throw new ProductQtyNotEnoughException("庫存不足", "目前庫存: " + qty + " 欲購買總數量: " + totalAmount);
			} catch (ProductQtyNotEnoughException e) {
				req.setAttribute("baseException", e);
				req.getRequestDispatcher("/WEB-INF/jsp/login/error_result.jsp").forward(req, resp);
				return;
			}
		}
		
		// 設定數量
		cartDto.setAmount(newAmount);
		
		// 將商品放入到 cart 中
		cart.put(productId, cartDto);		
		// 寫入到 session
		session.setAttribute("cart", cart);
		// 重導到 jsp
		req.getRequestDispatcher("/WEB-INF/jsp/login/product_cart.jsp").forward(req, resp);
	}
	
	
}
