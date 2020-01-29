package com.onlineexam.model;

public class UserAnswer {

	private String userEmail;
	private String examName;
	private int score;
	private String dateOfExam;
	private int timeTaken;

	public UserAnswer() {
		super();
	}

	public UserAnswer(String userEmail, String examName, int score, String dateOfExam, int timeTaken) {
		super();
		this.userEmail = userEmail;
		this.examName = examName;
		this.score = score;
		this.dateOfExam = dateOfExam;
		this.timeTaken = timeTaken;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
