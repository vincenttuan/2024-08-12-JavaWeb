package login.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.dto.OrderItemDto;
import login.service.OrderItemService;

@WebServlet("/product/order/item/list")
public class ProductOrderItemServlet extends HttpServlet {
	private OrderItemService orderItemService = new OrderItemService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 orderId 並轉型
		Integer orderId = Integer.parseInt(req.getParameter("orderId"));
		List<OrderItemDto> orderItemDtos = orderItemService.findAllOrderItemsByOrderId(orderId);
		
		req.setAttribute("orderItemDtos", orderItemDtos);
		
		req.getRequestDispatcher("/WEB-INF/jsp/login/order_item_list.jsp").forward(req, resp);
	}
	
}
