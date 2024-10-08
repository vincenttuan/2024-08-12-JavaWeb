package login.service;

import java.util.ArrayList;
import java.util.List;

import login.dao.OrderItemDao;
import login.dao.OrderItemDaoImpl;
import login.dto.CartDto;
import login.dto.OrderItemDto;
import login.entity.OrderItem;

public class OrderItemService {
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	public List<OrderItemDto> findAllOrderItemsByOrderId(Integer orderId) {
		List<OrderItemDto> orderItemDtos = new ArrayList<>();
		List<OrderItem> orderItems = orderItemDao.findAllOrderItemsByOrderId(orderId);
		for(OrderItem orderItem : orderItems) {
			OrderItemDto orderItemDto = new OrderItemDto();
			orderItemDto.setItemId(orderItem.getItemId());
			orderItemDto.setOrderId(orderItem.getOrderId());
			orderItemDto.setProductId(orderItem.getProductId());
			orderItemDto.setProductName(null);
			orderItemDto.setQuantity(orderItem.getQuantity());
			orderItemDto.setUnitPrice(orderItem.getUnitPrice());
			// 注入到 orderItemDtos 集合
			orderItemDtos.add(orderItemDto);
		}
		
		return orderItemDtos;
	}
	
	public int addOrderItem(int orderId, CartDto cartDto) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(orderId);
		orderItem.setProductId(cartDto.getProductDto().getId());
		orderItem.setQuantity(cartDto.getAmount()); // 購買數量
		orderItem.setUnitPrice(cartDto.getProductDto().getPrice());
		return orderItemDao.addOrderItem(orderItem);
	}
}
