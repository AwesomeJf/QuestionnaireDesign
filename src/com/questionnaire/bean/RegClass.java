package com.questionnaire.bean;

public class RegClass {
	Integer id;
	String className;
	String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RegClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegClass(Integer id, String className, String description) {
		super();
		this.id = id;
		this.className = className;
		this.description = description;
	}
	@Override
	public String toString() {
		return "RegClass [id=" + id + ", className=" + className + ", description=" + description + "]";
	}
	
	
}
