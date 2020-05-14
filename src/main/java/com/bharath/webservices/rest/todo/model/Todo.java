package com.bharath.webservices.rest.todo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Todo() {
		
	}
	public Todo(Long id,String desc,String targetDate,boolean status, String user) {
		//this.id = id;
		this.desc = desc;
		this.targetDate = targetDate;
		this.Status = status;
		this.user = user;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", targetDate=" + targetDate + ", Status="
				+ Status + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	private String desc;
	private String targetDate;
	private boolean Status;
	
}
