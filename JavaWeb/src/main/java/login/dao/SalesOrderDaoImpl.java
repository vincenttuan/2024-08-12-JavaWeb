package login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import login.entity.SalesOrder;

public class SalesOrderDaoImpl extends BaseDao implements SalesOrderDao {

	@Override
	public List<SalesOrder> findAllSalesOrders() {
		String sql = "select order_id, customer_id, order_date, total_amount, order_status from sales_order";
		List<SalesOrder> salesOrders = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			// 將每一筆紀錄放到 SalesOrder 物件中
			while(rs.next()) {
				SalesOrder salesOrder = new SalesOrder();
				salesOrder.setOrderId(rs.getInt("order_id"));
				salesOrder.setCustomerId(rs.getInt("customer_id"));
				salesOrder.setOrderDate(rs.getDate("order_date"));
				salesOrder.setTotalAmount(rs.getDouble("total_amount"));
				salesOrder.setOrderStatus(rs.getString("order_status"));
				// 注入到 salesOrders 集合中保存
				salesOrders.add(salesOrder);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesOrders;
	}
	
	
}
