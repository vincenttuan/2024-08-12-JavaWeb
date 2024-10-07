package login.exception;

// 自訂登入錯誤例外
public class ProductQtyNotEnoughException extends BaseException {
	public ProductQtyNotEnoughException(String title, String errorMsg) {
		super(title, errorMsg);
	}
}
