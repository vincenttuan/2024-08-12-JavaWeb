package login.dto;

// 購物車 Dto
public class CartDto {
	private int productId; // 商品編號
	private int amount;    // 商品數量
	private ProductDto productDto; // 商品資訊
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	
	
}
