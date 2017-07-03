package com.bokaro.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContactUsDTO {
	 
	private Long id;
	private String name;
	private String email;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ContactUsDTO [id=" + id + ", name=" + name + ", email=" + email + ", comment=" + comment
				+ ", createDate=" + createDate + "]";
	}

}
