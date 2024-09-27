package login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.entity.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	@Override
	public List<OrderItem> findAllOrderItemsByOrderId(Integer orderId) {
		List<OrderItem> orderItems = new ArrayList<>();
		String sql = "select item_id, order_id, product_id, quantity, unit_price from order_item where order_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, orderId);
			try(ResultSet rs = pstmt.executeQuery()) {
				// 資料逐筆取出
				while (rs.next()) {
					// 建立 OrderItem 物件並放入相關資料
					OrderItem orderItem = new OrderItem();
					orderItem.setItemId(rs.getInt("item_id"));
					orderItem.setOrderId(rs.getInt("order_id"));
					orderItem.setProductId(rs.getInt("product_id"));
					orderItem.setQuantity(rs.getInt("quantity"));
					orderItem.setUnitPrice(rs.getDouble("unit_price"));
					// 注入到 orderItems 集合
					orderItems.add(orderItem);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItems;
	}
	
}
