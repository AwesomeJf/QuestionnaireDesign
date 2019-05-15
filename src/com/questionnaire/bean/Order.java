package com.questionnaire.bean;

public class Order {
	Integer id;
	Integer studentId;
	Integer giftId;
	String giftName;
	String address;
	String status;
	String submitTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getGiftId() {
		return giftId;
	}
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer id, Integer studentId, Integer giftId, String giftName, String address, String status,
			String submitTime) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.giftId = giftId;
		this.giftName = giftName;
		this.address = address;
		this.status = status;
		this.submitTime = submitTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", studentId=" + studentId + ", giftId=" + giftId + ", giftName=" + giftName
				+ ", address=" + address + ", status=" + status + ", submitTime=" + submitTime + "]";
	}
	
}
