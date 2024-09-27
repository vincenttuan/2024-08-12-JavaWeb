package login.dto;

// 要呈顯給網頁看的資料
public class OrderItemDto {
	private Integer itemId;      // 對應欄位: OrderItem.itemId
	private Integer orderId;     // 對應欄位: OrderItem.orderId
	private Integer productId;   // 對應欄位: OrderItem.productId
	private String productName; // 對應欄位: Product.productName
	private Integer quantity;    // 對應欄位: OrderItem.quantity
	private Double unitPrice;    // 對應欄位: OrderItem.unitPrice
	
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
