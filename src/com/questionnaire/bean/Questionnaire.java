package com.questionnaire.bean;

public class Questionnaire {
	Integer id;
	Integer sponsorId;
	Integer score;
	String questionnaireTitle;
	String questionnaireDescription;
	String questionnaireType;
	String submitTime;
	String status;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getQuestionnaireTitle() {
		return questionnaireTitle;
	}
	public void setQuestionnaireTitle(String questionnaireTitle) {
		this.questionnaireTitle = questionnaireTitle;
	}
	public String getQuestionnaireDescription() {
		return questionnaireDescription;
	}
	public void setQuestionnaireDescription(String questionnaireDescription) {
		this.questionnaireDescription = questionnaireDescription;
	}
	public String getQuestionnaireType() {
		return questionnaireType;
	}
	public void setQuestionnaireType(String questionnaireType) {
		this.questionnaireType = questionnaireType;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Questionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionnaire(Integer id, Integer sponsorId, Integer score, String questionnaireTitle,
			String questionnaireDescription, String questionnaireType, String submitTime, String status) {
		super();
		this.id = id;
		this.sponsorId = sponsorId;
		this.score = score;
		this.questionnaireTitle = questionnaireTitle;
		this.questionnaireDescription = questionnaireDescription;
		this.questionnaireType = questionnaireType;
		this.submitTime = submitTime;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", sponsorId=" + sponsorId + ", score=" + score + ", questionnaireTitle="
				+ questionnaireTitle + ", questionnaireDescription=" + questionnaireDescription + ", questionnaireType="
				+ questionnaireType + ", submitTime=" + submitTime + ", status=" + status + "]";
	}
	

}
