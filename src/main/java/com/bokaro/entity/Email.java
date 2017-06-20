package com.bokaro.entity;

public class Email {
	
	private String to;
	
	private String subject;
	
	private String velocityTemplate;

	
	public Email(String to, String subject, String velocityTemplate) {
		super();
		this.to = to;
		this.subject = subject;
		this.velocityTemplate = velocityTemplate;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the velocityTemplate
	 */
	public String getVelocityTemplate() {
		return velocityTemplate;
	}

	/**
	 * @param velocityTemplate the velocityTemplate to set
	 */
	public void setVelocityTemplate(String velocityTemplate) {
		this.velocityTemplate = velocityTemplate;
	}
	
}
