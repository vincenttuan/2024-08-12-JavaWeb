package login.entity;

// 對應 order_item 資料表中的欄位
public class OrderItem {
	private Integer itemId;    // 對應欄位: item_id
	private Integer orderId;   // 對應欄位: order_id
	private Integer productId; // 對應欄位: product_id
	private Integer quantity;  // 對應欄位: quantity
	private Double unitPrice;  // 對應欄位: unit_price
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
	
}
