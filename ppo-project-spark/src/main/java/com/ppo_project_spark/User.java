package com.ppo_project_spark;

import java.util.UUID;

public class User {

	private String id;
	private String name;
	private String email;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String name, String email) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
	}
	public User(String name, String email,int age) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.age=age;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

