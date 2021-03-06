package com.ekarudianto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	@Id
    private String id;
	
    private int age;
    private String country; 
    private String name;
    
    public User() {
    	super();
    }
    
    public User(String name, int age, String country) {
    	this.name = name;
    	this.age = age;
    	this.country = country;
    }
    
    public User(String id, String name, int age, String country) {
    	this.id = id;
    	this.name = name;
    	this.age = age;
    	this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String toString() {
    	return  "Id : " + this.id +
    			" Name : " + this.name +
    			" Age : " + this.age + 
    			" Country : " + this.country;
    }
}