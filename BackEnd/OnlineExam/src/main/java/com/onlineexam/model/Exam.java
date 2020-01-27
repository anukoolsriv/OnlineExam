package com.onlineexam.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "exam")
public class Exam implements Serializable{

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

	@JsonManagedReference
	@OneToMany(mappedBy = "exam", fetch=FetchType.LAZY)
	private List<CacheTable> cacheTable;

	@JsonManagedReference
	@OneToMany(mappedBy = "exam", fetch=FetchType.LAZY)
	private List<Questions> questions;

	@JsonManagedReference
	@OneToMany(mappedBy = "exam", fetch=FetchType.LAZY)
	private List<UserScore> scores;

	@JsonManagedReference
	@ManyToMany(mappedBy = "exams", fetch=FetchType.LAZY)
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

	public List<CacheTable> getCacheTable() {
		return cacheTable;
	}

	public void setCacheTable(List<CacheTable> cacheTable) {
		this.cacheTable = cacheTable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examName == null) ? 0 : examName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (examName == null) {
			if (other.examName != null)
				return false;
		} else if (!examName.equals(other.examName))
			return false;
		return true;
	}
	//
	// @Override
	// public boolean equals(Object obj) {
	//
	// if (obj instanceof Exam) {
	//
	// Exam e = (Exam) obj;
	//
	// if (this.examName == e.examName) {
	// return true;
	// } else {
	// return false;
	// }
	// }
	// else{
	// return false;
	// }
	// }
}
