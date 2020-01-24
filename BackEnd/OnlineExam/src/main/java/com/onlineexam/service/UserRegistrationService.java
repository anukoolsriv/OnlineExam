package com.onlineexam.service;

import com.onlineexam.model.User;

public interface UserRegistrationService {
	public boolean addUser(User user);
	public boolean updatePassword(char[] OTP, String email);
}
