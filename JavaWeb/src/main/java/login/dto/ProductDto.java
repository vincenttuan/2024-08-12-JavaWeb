package login.dto;

// product dto 資料
public class ProductDto {
	private int id;       // 對應 entity 欄位: productId
	private String name;  // 對應 entity 欄位: productName
	private double price; // 對應 entity 欄位: price
	private int qty;      // 對應 entity 欄位: stockQuantity
	private String imageBase64; // 對應 entity 欄位: imageBase64 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	
	
}
