package com.transaction.Users.model;

public class JwtResponce {

	String token;

	public JwtResponce(String token) {
		super();
		this.token = token;
	}
	public JwtResponce(){
		
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "JwtResponce [token=" + token + "]";
	}
}
