package com.bokaro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "update_notification")
public class UpdateNotification implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

	public UpdateNotification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateNotification(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	@Override
	public String toString() {
		return "UpdateNotification [id=" + id + ", message=" + message + "]";
	}
	
}
