package com.example.RestAPI;

import java.util.Date;

public class UserException {
	
	private Date timestamp;
	private String message;
	private String details;
	public Date getTimestamp() {
		return timestamp;
	}
	public UserException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
