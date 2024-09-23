package login.exception;

public class ProductDaoRuntimeException extends RuntimeException {
	public ProductDaoRuntimeException(String errorMessage) {
		super(errorMessage);
	}
}
