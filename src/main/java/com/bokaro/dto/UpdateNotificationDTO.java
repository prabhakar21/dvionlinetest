package com.bokaro.dto;

public class UpdateNotificationDTO {

	private Long id;
	private String message;
	
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
