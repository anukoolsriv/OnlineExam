package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

public interface UserRegistrationDao {
	public User addUser(User user);
	public int addUserLogin(UserLogin userLogin);
	public int validateLogin(UserLogin userLogin);
	public List<Exam> getExams();
	public List<Questions> getExamQuestions(String exam);
}
