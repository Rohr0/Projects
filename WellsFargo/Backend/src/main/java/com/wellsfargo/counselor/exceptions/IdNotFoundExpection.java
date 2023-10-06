package com.wellsfargo.counselor.exceptions;

public class IdNotFoundExpection extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid ID";
	}
}
