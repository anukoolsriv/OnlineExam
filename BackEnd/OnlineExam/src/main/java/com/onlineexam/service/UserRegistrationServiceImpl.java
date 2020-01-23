package com.onlineexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.dao.UserRegistrationDao;
import com.onlineexam.functions.Functions;
import com.onlineexam.model.User;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationDao dao;

	@Override
	public boolean addUser(User user) {
		int isAdded = dao.addUser(user);
		char[] OTP;
		if (isAdded == 1) {
			OTP = Functions.generatePassword();
			System.out.println(OTP);
			// update otp in user_login
			// send otp to mail
			return true;
		} else {
			
			return false;
		}
	}

	public UserRegistrationDao getDao() {
		return dao;
	}

	public void setDao(UserRegistrationDao dao) {
		this.dao = dao;
	}

}
