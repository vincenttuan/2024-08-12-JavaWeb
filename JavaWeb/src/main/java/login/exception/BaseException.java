package login.exception;

// 自訂登入錯誤例外
public class BaseException extends Exception {
	private String title;
	private String errorMessage;
	public BaseException(String title, String errorMsg) {
		super(errorMsg);
		this.title = title;
		this.errorMessage = errorMessage;
	}
	public String getTitle() {
		return title;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	
}
