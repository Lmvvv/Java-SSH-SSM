package com.lh.web;

public class User {

	private int id;
	private String username;
	private String password;
	private int grant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGrant() {
		return grant;
	}
	public void setGrant(int grant) {
		this.grant = grant;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", grant=" + grant + "]";
	}
}
