package com.questionnaire.bean;

public class Question {
	Integer id;
	Integer ownerQuestionnaireId;
	String ownerQuestionnaireTitle;
	String questionHeading;
	String questionType;
	String optionA;
	String optionB;
	String optionC;
	String optionD;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOwnerQuestionnaireId() {
		return ownerQuestionnaireId;
	}
	public void setOwnerQuestionnaireId(Integer ownerQuestionnaireId) {
		this.ownerQuestionnaireId = ownerQuestionnaireId;
	}
	public String getOwnerQuestionnaireTitle() {
		return ownerQuestionnaireTitle;
	}
	public void setOwnerQuestionnaireTitle(String ownerQuestionnaireTitle) {
		this.ownerQuestionnaireTitle = ownerQuestionnaireTitle;
	}
	public String getQuestionHeading() {
		return questionHeading;
	}
	public void setQuestionHeading(String questionHeading) {
		this.questionHeading = questionHeading;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(Integer id, Integer ownerQuestionnaireId, String ownerQuestionnaireTitle, String questionHeading,
			String questionType, String optionA, String optionB, String optionC, String optionD) {
		super();
		this.id = id;
		this.ownerQuestionnaireId = ownerQuestionnaireId;
		this.ownerQuestionnaireTitle = ownerQuestionnaireTitle;
		this.questionHeading = questionHeading;
		this.questionType = questionType;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", ownerQuestionnaireId=" + ownerQuestionnaireId + ", ownerQuestionnaireTitle="
				+ ownerQuestionnaireTitle + ", questionHeading=" + questionHeading + ", questionType=" + questionType
				+ ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD
				+ "]";
	}
	
}
