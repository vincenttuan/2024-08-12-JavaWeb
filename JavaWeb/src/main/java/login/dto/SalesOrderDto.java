package login.dto;

import java.util.Date;

// 要呈顯給網頁看的資料
public class SalesOrderDto {
	private Integer orderId;     // 對應 SalesOrder.orderId
	private Integer userId;      // 對應 SalesOrder.customerId == User.userId
	private String  userName;    // 對應 User.userName
	private Date    orderDate;   // 對應 SalesOrder.orderDate
	private Double  totalAmount; // 對應 SalesOrder.totalAmount
	private String  orderStatus; // 對應 SalesOrder.orderStatus
	
	
}
