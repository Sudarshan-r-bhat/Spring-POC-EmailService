package com.practise.emailservicepractise.allInOne;


public class EmailUser {
	
	private String emailId;
	private String password;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "EmailUser [emailId=" + emailId + ", password=" + password + "]";
	}


}
