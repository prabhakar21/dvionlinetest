package com.bokaro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contact_us")
public class ContactUs {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContactUs(Long id, String name, String email, String comment, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.comment = comment;
		this.createDate = createDate;
	}

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
		return "ContactUs [id=" + id + ", name=" + name + ", email=" + email + ", comment=" + comment + ", createDate="
				+ createDate + "]";
	}
	
}
