package com.bharath.webservices.rest;

import java.io.Serializable;

public class HelloworldBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	HelloworldBean() {
		
	}
	HelloworldBean(String msg) {
		this.message =  msg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}