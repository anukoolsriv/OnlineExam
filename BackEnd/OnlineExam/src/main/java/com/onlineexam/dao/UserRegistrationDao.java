package com.onlineexam.dao;

import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

public interface UserRegistrationDao {
	public User addUser(User user);
	public int addUserLogin(UserLogin userLogin);
	public int validateLogin(UserLogin userLogin);
}
