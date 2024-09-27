package login.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.entity.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	@Override
	public List<OrderItem> findAllOrderItemsByOrderId(Integer orderId) {
		List<OrderItem> orderItems = new ArrayList<>();
		String sql = "select item_id, order_id, product_id, quantity, unit_price from order_item where order_id = ?";
		try() {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItems;
	}
	
}
