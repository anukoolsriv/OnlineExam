package com.onlineexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.dao.UserRegistrationDao;
import com.onlineexam.model.User;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationDao dao;

	@Override
	public boolean addUser(User user) {
		int result = dao.addUser(user);
		if (result == 1)
			return true;
		else
			return false;
	}

	public UserRegistrationDao getDao() {
		return dao;
	}

	public void setDao(UserRegistrationDao dao) {
		this.dao = dao;
	}

}
