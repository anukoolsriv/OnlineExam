package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cache_table")

public class CacheTable {
	@Id
	@Column(name="cache_id")
	private int cacheId;
	
	@Column(name="user_id")
	private int userId;
	@Column(name="exam_id")
	private int examId;
	@Column(name="question_id")
	private int questionId;
	@Column(name="Ans_selected")
	private String ansSelected;

	public CacheTable() {
		super();
	}
	public CacheTable(int cacheId, int userId, int examId, int questionId, String ansSelected) {
		super();
		this.cacheId = cacheId;
		this.userId = userId;
		this.examId = examId;
		this.questionId = questionId;
		this.ansSelected = ansSelected;
	}
	public int getCacheId() {
		return cacheId;
	}
	public void setCacheId(int cacheId) {
		this.cacheId = cacheId;
	}
	public void setAnsSelected(String ansSelected) {
		this.ansSelected = ansSelected;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnsSelected() {
		return ansSelected;
	}
	public void setAnswerSelected(String ansSelected) {
		this.ansSelected = ansSelected;
	}
}
