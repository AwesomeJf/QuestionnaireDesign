package com.questionnaire.bean;

public class Answer {
	Integer id;
	Integer ownerQuestionnaireId;
	Integer ownerQuestionId;
	String ownerQuestionHeading;
	Integer ownerStudentId;
	String option;
	String answer;
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
	public Integer getOwnerQuestionId() {
		return ownerQuestionId;
	}
	public void setOwnerQuestionId(Integer ownerQuestionId) {
		this.ownerQuestionId = ownerQuestionId;
	}
	public String getOwnerQuestionHeading() {
		return ownerQuestionHeading;
	}
	public void setOwnerQuestionHeading(String ownerQuestionHeading) {
		this.ownerQuestionHeading = ownerQuestionHeading;
	}
	public Integer getOwnerStudentId() {
		return ownerStudentId;
	}
	public void setOwnerStudentId(Integer ownerStudentId) {
		this.ownerStudentId = ownerStudentId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(Integer id, Integer ownerQuestionnaireId, Integer ownerQuestionId, String ownerQuestionHeading,
			Integer ownerStudentId, String option, String answer) {
		super();
		this.id = id;
		this.ownerQuestionnaireId = ownerQuestionnaireId;
		this.ownerQuestionId = ownerQuestionId;
		this.ownerQuestionHeading = ownerQuestionHeading;
		this.ownerStudentId = ownerStudentId;
		this.option = option;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", ownerQuestionnaireId=" + ownerQuestionnaireId + ", ownerQuestionId="
				+ ownerQuestionId + ", ownerQuestionHeading=" + ownerQuestionHeading + ", ownerStudentId="
				+ ownerStudentId + ", option=" + option + ", answer=" + answer + "]";
	}
	
	
}
