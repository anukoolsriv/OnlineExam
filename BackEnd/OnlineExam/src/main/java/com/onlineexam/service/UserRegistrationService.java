package com.onlineexam.service;

import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

public interface UserRegistrationService {
	public boolean addUser(User user);
	public boolean validateLogin(UserLogin userLogin);
}
