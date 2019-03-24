package com.example.RestAPI;

import java.util.Date;

public class UserAccount {
	
	private Integer id;
	private String name;
	private Date dob;
	
	//there should be a default no-arg constructor, if the parameterized
	//constructor below would not have been there, java would have
	//provided a no-arg constructor by default, but since we have created
	//a parametrized constructor by ourself, we have to have a no-arg constructor.
	// since in a post method, we are creating a new user, so we have to have a no-arg constructor
	
	public UserAccount() {
		
	}
	public UserAccount(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	

}
