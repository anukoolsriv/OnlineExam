package com.onlineexam.service;

import java.util.List;
import java.util.Set;

import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

public interface UserRegistrationService {
	public boolean addUser(User user);
	public boolean validateLogin(UserLogin userLogin);
	public Set<Exam> fetchExams();
	public List<Questions> getExamQuestions(String exam);
	public boolean validateAnswer(int questionId, String answerGiven);
}
