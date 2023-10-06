package com.wellsfargo.counselor.entity;

public class ResponseStructure<T> {
	private T data;
	private String message;
	private int statusCode;

	public ResponseStructure() {
	}

	public ResponseStructure(T data, String message, int statusCode) {
		super();
		this.data = data;
		this.message = message;
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
