package com.onlineexam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_score")
public class UserScore {

	@Id
	@Column(name = "user_score_id")
	private int userScoreId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id")
	private Exam exam;

	@Column(name = "score_per_attempt")
	private int scorePerAttempt;
	
	@Column(name = "date_of_exam")
	private String dateOfExam;
	
	@Column(name = "time_taken")
	private int timeTaken;

	public UserScore() {
		super();
	}

	
	public UserScore(int userScoreId, User user, Exam exam, int scorePerAttempt, String dateOfExam, int timeTaken) {
		super();
		this.userScoreId = userScoreId;
		this.user = user;
		this.exam = exam;
		this.scorePerAttempt = scorePerAttempt;
		this.dateOfExam = dateOfExam;
		this.timeTaken = timeTaken;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Exam getExam() {
		return exam;
	}


	public void setExam(Exam exam) {
		this.exam = exam;
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
	public int getUserScoreId() {
		return userScoreId;
	}

	public void setUserScoreId(int userScoreId) {
		this.userScoreId = userScoreId;
	}
}
