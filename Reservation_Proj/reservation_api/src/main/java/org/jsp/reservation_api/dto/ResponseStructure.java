package org.jsp.reservation_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {	
	private T data;
	private String message;
	private int statusCode;

}
