package com.questionnaire.bean;

public class Announce {
	Integer id;
	Integer sponsorId;
	String content;
	String submitTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public Announce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Announce(Integer id, Integer sponsorId, String content, String submitTime) {
		super();
		this.id = id;
		this.sponsorId = sponsorId;
		this.content = content;
		this.submitTime = submitTime;
	}
	@Override
	public String toString() {
		return "Announce [id=" + id + ", sponsorId=" + sponsorId + ", content=" + content + ", submitTime=" + submitTime
				+ "]";
	}
	
}
