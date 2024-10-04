package login.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import login.dao.SalesOrderDao;
import login.dao.SalesOrderDaoImpl;
import login.dao.UserDao;
import login.dto.CartDto;
import login.dto.SalesOrderDto;
import login.entity.SalesOrder;
import login.entity.User;

public class SalesOrderService {
	private SalesOrderDao salesOrderDao = new SalesOrderDaoImpl();
	private UserDao userDao = new UserDao();
	private OrderItemService orderItemService = new OrderItemService();
	
	public List<SalesOrderDto> findAllSalesOrderDtos() {
		List<SalesOrderDto> salesOrderDtos = new ArrayList<>();
		// 取得所有 salesOrders
		List<SalesOrder> salesOrders = salesOrderDao.findAllSalesOrders();
		// 將每一筆 SalesOrder 物件屬性資料對應到 SalesOrderDto 物件屬性中
		for(SalesOrder salesOrder : salesOrders) {
			SalesOrderDto salesOrderDto = new SalesOrderDto();
			salesOrderDto.setOrderId(salesOrder.getOrderId());
			salesOrderDto.setUserId(salesOrder.getCustomerId());
			// 利用 userDao + userId 來取得 User 物件
			Optional<User> optUser = userDao.getUserById(salesOrderDto.getUserId());
			if(optUser.isPresent()) {
				User user = optUser.get();
				salesOrderDto.setUserName(user.getUserName());
			}
			salesOrderDto.setOrderDate(salesOrder.getOrderDate());
			salesOrderDto.setTotalAmount(salesOrder.getTotalAmount());
			salesOrderDto.setOrderStatus(salesOrder.getOrderStatus());
			// 注入到 salesOrderDtos 集合中
			salesOrderDtos.add(salesOrderDto);
		}
		return salesOrderDtos;
	}
	
	// 購物車結帳
	public void submit(int customerId, Map<Integer, CartDto> cart) {
		// 新增訂單主檔
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setCustomerId(customerId);
		salesOrder.setOrderDate(new Date());
		salesOrder.setOrderStatus("Finished");
		double total = cart.values()
							.stream()
							.mapToDouble(ca -> ca.getAmount() * ca.getProductDto().getPrice())
							.sum();
		salesOrder.setTotalAmount(total); // 總價
		int orderId = salesOrderDao.addSalesOrder(salesOrder);
		
		// 新增訂單項目
		cart.values().forEach(cartDto -> orderItemService.addOrderItem(orderId, cartDto));
		
	}
}
