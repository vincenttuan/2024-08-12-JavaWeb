package login.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
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

	@Override
	public int addSalesOrder(SalesOrder salesOrder) {
		String sql = "insert into sales_order(customer_id, order_date, total_amount, order_status) values(?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			pstmt.setInt(1, salesOrder.getCustomerId());
			pstmt.setDate(2, new java.sql.Date(salesOrder.getOrderDate().getTime()));
			pstmt.setDouble(3, salesOrder.getTotalAmount());
			pstmt.setString(4, salesOrder.getOrderStatus());
			// 新增
			pstmt.executeUpdate();
			// 取得自動生成的 order_id
			ResultSet generateKeys = pstmt.getGeneratedKeys();
			if(generateKeys.next()) {
				return generateKeys.getInt(1); // 第一個 column
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
