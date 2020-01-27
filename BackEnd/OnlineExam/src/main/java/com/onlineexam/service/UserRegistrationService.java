package com.onlineexam.service;

import java.util.List;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import com.onlineexam.model.Exam;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

public interface UserRegistrationService {
	public boolean addUser(User user);
	public boolean validateLogin(UserLogin userLogin);
	public Set<Exam> fetchExams();
	public List<Question> getExamQuestions(String exam);
}
