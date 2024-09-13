package login.exception;

// 自訂登入錯誤例外
public class LoginException extends Exception {
	public LoginException(String errorMsg) {
		super(errorMsg);
	}
}
