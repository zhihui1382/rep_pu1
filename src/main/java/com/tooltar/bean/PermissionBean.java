package com.tooltar.bean;

import java.io.Serializable;

public class PermissionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String message;
	
	public PermissionBean() {
		super();
	}
	public PermissionBean(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "PermissionBean [id=" + id + ", message=" + message + "]";
	}
	
}
