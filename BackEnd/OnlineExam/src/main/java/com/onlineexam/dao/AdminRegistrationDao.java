package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

public interface AdminRegistrationDao {
	public boolean uploadFile(User user);
}
