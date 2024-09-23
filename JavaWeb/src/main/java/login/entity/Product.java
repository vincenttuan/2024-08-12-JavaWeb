package login.entity;

// 對應 product 資料表欄位
public class Product {
	private int productId;      // 對應欄位: product_id
	private String productName; // 對應欄位: product_name
	private double price;       // 對應欄位: price
	private int stockQuantity;  // 對應欄位: stock_quantity
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + "]";
	}
	
	
}
