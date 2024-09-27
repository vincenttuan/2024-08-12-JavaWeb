package login.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.dto.SalesOrderDto;
import login.service.SalesOrderService;

@WebServlet("/product/order/list")
public class ProductOrderListServlet extends HttpServlet {
	
	private SalesOrderService salesOrderService = new SalesOrderService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SalesOrderDto> salesOrderDtos = salesOrderService.findAllSalesOrderDtos();
		req.setAttribute("salesOrderDtos", salesOrderDtos);
		req.getRequestDispatcher("/WEB-INF/jsp/login/order_list.jsp").forward(req, resp);
	}
	
}
