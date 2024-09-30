package login.entity;

// 對應 product 資料表欄位
public class Product {
	private int productId;      // 對應欄位: product_id
	private String productName; // 對應欄位: product_name
	private double price;       // 對應欄位: price
	private int stockQuantity;  // 對應欄位: stock_quantity
	private String imageBase64; // 對應欄位: image_base64
	
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
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	
	
	
	
}
