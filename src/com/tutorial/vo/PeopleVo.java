package com.tutorial.vo;

import java.sql.Timestamp;

public class PeopleVo {
	private int id;
	//need to keep this arg,(spring lib need)
	//but you don't need to set it,
	//because this column is auto gen
	
	private String name;
	private String school;
	private int age;
	
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
