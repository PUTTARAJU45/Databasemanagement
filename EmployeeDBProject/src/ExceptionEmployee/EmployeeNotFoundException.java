package ExceptionEmployee;

public class EmployeeNotFoundException extends RuntimeException{
	private String Message;

	public EmployeeNotFoundException(String message) {
		Message = message;
	}
	public String getMessage() {
		return Message;
	}
	

}
