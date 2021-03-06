package com.yicheng.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 4682417155747396928L;

	private int id;
	private String name;
	private String password;
	private int type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public User() {}
	
	public User(int id) {
		this.id = id;
	}
}
