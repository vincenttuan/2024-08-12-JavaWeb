package login.dao;

import java.util.List;

import login.entity.SalesOrder;

public interface SalesOrderDao {
	List<SalesOrder> findAllSalesOrders();
}
