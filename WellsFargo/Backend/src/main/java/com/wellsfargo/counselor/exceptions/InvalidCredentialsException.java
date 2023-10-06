package com.wellsfargo.counselor.exceptions;

public class InvalidCredentialsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid Phone or Email or Password";
	}
}
