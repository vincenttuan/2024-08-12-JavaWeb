package login.service;

import java.util.ArrayList;
import java.util.List;

import login.dao.SalesOrderDao;
import login.dao.SalesOrderDaoImpl;
import login.dao.UserDao;
import login.dto.SalesOrderDto;
import login.entity.SalesOrder;

public class SalesOrderService {
	private SalesOrderDao salesOrderDao = new SalesOrderDaoImpl();
	private UserDao userDao = new UserDao();
	
	public List<SalesOrderDto> findAllSalesOrderDtos() {
		List<SalesOrderDto> salesOrderDtos = new ArrayList<>();
		// 取得所有 salesOrders
		List<SalesOrder> salesOrders = salesOrderDao.findAllSalesOrders();
		// 將每一筆 SalesOrder 物件屬性資料對應到 SalesOrderDto 物件屬性中
		for(SalesOrder salesOrder : salesOrders) {
			SalesOrderDto salesOrderDto = new SalesOrderDto();
			salesOrderDto.setOrderId(salesOrder.getOrderId());
			salesOrderDto.setUserId(salesOrder.getCustomerId());
			salesOrderDto.setUserName(null); // 等一下再寫
			salesOrderDto.setOrderDate(salesOrder.getOrderDate());
			salesOrderDto.setTotalAmount(salesOrder.getTotalAmount());
			salesOrderDto.setOrderStatus(salesOrder.getOrderStatus());
			// 注入到 salesOrderDtos 集合中
			salesOrderDtos.add(salesOrderDto);
		}
		return salesOrderDtos;
	}
}
