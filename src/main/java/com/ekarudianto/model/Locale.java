package com.ekarudianto.model;

public class Locale {
	
	private String usersNotFound;
	private String mustNotProvideId;
	
	public Locale() {}
	
	public String getMustNotProvideId() {
		return mustNotProvideId;
	}
	
	public void setMustNotProvideId(String mustNotProvideId) {
		this.mustNotProvideId = mustNotProvideId;
	}
	
	public String getUsersNotFound() {
		return usersNotFound;
	}
	
	public void setUsersNotFound(String usersNotFound) {
		this.usersNotFound = usersNotFound;
	}
}
