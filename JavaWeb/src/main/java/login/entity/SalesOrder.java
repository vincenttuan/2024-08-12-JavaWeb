package login.entity;

import java.util.Date;

// 對應 sales_order 資料表中的欄位
public class SalesOrder {
	private Integer orderId;    // 對應欄位: order_id
	private Integer customerId; // 對應欄位: customer_id
	private Date orderDate;     // 對應欄位: order_date
	private Double totalAmount; // 對應欄位: total_amount
	private String orderStatus; // 對應欄位: order_status
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
