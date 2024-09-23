package login.dto;

// product dto 資料
public class ProductDto {
	private int id;       // 對應 entity 欄位: productId
	private String name;  // 對應 entity 欄位: productName
	private double price; // 對應 entity 欄位: price
	private int qty;      // 對應 entity 欄位: stockQuantity
	
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
	
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
}
