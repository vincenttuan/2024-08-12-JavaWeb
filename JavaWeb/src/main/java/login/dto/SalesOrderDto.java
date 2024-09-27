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
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
}
