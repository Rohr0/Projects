package org.jsp.reservation_api.Exception;

public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Id Not Found Exception";
	}

}
