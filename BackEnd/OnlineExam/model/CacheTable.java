package com.onlineexam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cache_table")

public class CacheTable {
	@Id
	@Column(name = "cache_id")
	private int cacheId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id")
	private Exam exam;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private Questions question;

	@Column(name = "ans_selected")
	private String ansSelected;

	public CacheTable() {
		super();
	}

	public CacheTable(int cacheId, User user, Exam exam, Questions question, String ansSelected) {
		super();
		this.cacheId = cacheId;
		this.user = user;
		this.exam = exam;
		this.question = question;
		this.ansSelected = ansSelected;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
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

	public String getAnsSelected() {
		return ansSelected;
	}

	public void setAnswerSelected(String ansSelected) {
		this.ansSelected = ansSelected;
	}
}
