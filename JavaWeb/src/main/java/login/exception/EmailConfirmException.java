package login.exception;

// 自訂登入錯誤例外
public class EmailConfirmException extends Exception {
	public EmailConfirmException(String errorMsg) {
		super(errorMsg);
	}
}
