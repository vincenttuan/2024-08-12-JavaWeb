package login.service;

import java.util.ArrayList;
import java.util.List;

import login.dao.OrderItemDao;
import login.dao.OrderItemDaoImpl;
import login.dto.OrderItemDto;

public class OrderItemService {
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	public List<OrderItemDto> findAllOrderItemsByOrderId(Integer orderId) {
		List<OrderItemDto> orderItemDtos = new ArrayList<>();
		
		return orderItemDtos;
	}
}
