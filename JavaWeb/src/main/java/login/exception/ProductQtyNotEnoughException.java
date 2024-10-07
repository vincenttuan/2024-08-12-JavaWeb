package login.exception;

// 自訂登入錯誤例外
public class ProductQtyNotEnoughException extends Exception {
	public ProductQtyNotEnoughException(String errorMsg) {
		super(errorMsg);
	}
}
