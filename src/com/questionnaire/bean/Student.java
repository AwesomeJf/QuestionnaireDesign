package com.questionnaire.bean;

public class Student {
	Integer id;
	Integer ownerClassId;
	String phoneNumber;
	Integer score;
	Integer studyNumber;
	String account;
	String password;
	String name;
	String sex;
	String address;
	String isAdmin;
	String registerTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOwnerClassId() {
		return ownerClassId;
	}
	public void setOwnerClassId(Integer ownerClassId) {
		this.ownerClassId = ownerClassId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getStudyNumber() {
		return studyNumber;
	}
	public void setStudyNumber(Integer studyNumber) {
		this.studyNumber = studyNumber;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, Integer ownerClassId, String phoneNumber, Integer score, Integer studyNumber,
			String account, String password, String name, String sex, String address, String isAdmin,
			String registerTime) {
		super();
		this.id = id;
		this.ownerClassId = ownerClassId;
		this.phoneNumber = phoneNumber;
		this.score = score;
		this.studyNumber = studyNumber;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.isAdmin = isAdmin;
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", ownerClassId=" + ownerClassId + ", phoneNumber=" + phoneNumber + ", score="
				+ score + ", studyNumber=" + studyNumber + ", account=" + account + ", password=" + password + ", name="
				+ name + ", sex=" + sex + ", address=" + address + ", isAdmin=" + isAdmin + ", registerTime="
				+ registerTime + "]";
	}
	
	
}
