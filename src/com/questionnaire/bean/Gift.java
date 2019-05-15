package com.questionnaire.bean;

public class Gift {
	Integer id;
	Integer score;
	String giftName;
	String giftDescription;
	String giftSrc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftDescription() {
		return giftDescription;
	}
	public void setGiftDescription(String giftDescription) {
		this.giftDescription = giftDescription;
	}
	public String getGiftSrc() {
		return giftSrc;
	}
	public void setGiftSrc(String giftSrc) {
		this.giftSrc = giftSrc;
	}
	public Gift() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gift(Integer id, Integer score, String giftName, String giftDescription, String giftSrc) {
		super();
		this.id = id;
		this.score = score;
		this.giftName = giftName;
		this.giftDescription = giftDescription;
		this.giftSrc = giftSrc;
	}
	@Override
	public String toString() {
		return "Gift [id=" + id + ", score=" + score + ", giftName=" + giftName + ", giftDescription=" + giftDescription
				+ ", giftSrc=" + giftSrc + "]";
	}
}
