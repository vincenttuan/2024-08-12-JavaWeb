package login.dao;

import java.util.List;

import login.entity.OrderItem;

public interface OrderItemDao {
	List<OrderItem> findAllOrderItemsByOrderId(Integer orderId);
}
