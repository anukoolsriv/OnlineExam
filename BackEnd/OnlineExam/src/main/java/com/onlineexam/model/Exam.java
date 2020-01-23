package com.onlineexam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@Column(name = "exam_id")
	private int examId;

	@Column(name = "exam_name")
	private String examName;

	@Column(name = "exam_date")
	private String examDate;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "end_time")
	private String endTime;
	
	@OneToMany(mappedBy="exam")
	private List<UserScore> userScores;
	
	@OneToMany(mappedBy="exam")
	private List<Questions> questions;

	@OneToMany(mappedBy="exam")
	private List<UserScore> scores;

	@ManyToMany(mappedBy="exams")
	private List<AdminLogin> adminLogins;
	
		public Exam() {
		super();
	}

	public Exam(int examId, String examName, String examDate, String startTime, String endTime,
			List<Questions> questions, List<UserScore> scores, List<AdminLogin> adminLogins) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDate = examDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.questions = questions;
		this.scores = scores;
		this.adminLogins = adminLogins;
	}

	public List<UserScore> getScores() {
		return scores;
	}

	public void setScores(List<UserScore> scores) {
		this.scores = scores;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public List<AdminLogin> getAdminLogins() {
		return adminLogins;
	}

	public void setAdminLogins(List<AdminLogin> adminLogins) {
		this.adminLogins = adminLogins;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
