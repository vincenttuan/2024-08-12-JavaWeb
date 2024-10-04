package login.controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.dto.CartDto;
import login.dto.UserDto;
import login.service.SalesOrderService;

@WebServlet("/product/submit")
public class ProductSubmit extends HttpServlet {
	private SalesOrderService salesOrderService = new SalesOrderService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDto userDto = (UserDto)session.getAttribute("userDto");
		Map<Integer, CartDto> cart = (Map<Integer, CartDto>)session.getAttribute("cart");
		salesOrderService.submit(userDto.getUserId(), cart);
		// 清除購物車 session 資料
		session.setAttribute("cart", null);
		
		resp.getWriter().print("Submit OK");
	}
	
}
