package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_score")
public class UserScore {
	
	@Id
	@Column(name="user_score_id")
	private int user_score_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@Column(name="user_id")
	private int userId;
	@ManyToOne(cascade=CascadeType.ALL)
	@Column(name="exam_id")
	private int examId;
	@Column(name="score_per_attempt")
	private int scorePerAttempt;
	@Column(name="date_of_exam")
	private String dateOfExam;
	@Column(name="time_taken")
	private int timeTaken;
	
	public UserScore() {
		super();
	}
	public UserScore(int userId, int examId, int scorePerAttempt, String dateOfExam, int timeTaken) {
		super();
		this.userId = userId;
		this.examId = examId;
		this.scorePerAttempt = scorePerAttempt;
		this.dateOfExam = dateOfExam;
		this.timeTaken = timeTaken;
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
	public int getScorePerAttempt() {
		return scorePerAttempt;
	}
	public void setScorePerAttempt(int scorePerAttempt) {
		this.scorePerAttempt = scorePerAttempt;
	}
	public String getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(String dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

}
