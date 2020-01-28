package com.onlineexam.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.dao.AdminRegistrationDao;
import com.onlineexam.dao.UserRegistrationDao;
import com.onlineexam.functions.Functions;
import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService {

	@Autowired
	private AdminRegistrationDao dao;

	public AdminRegistrationDao getDao() {
		return dao;
	}

	public void setDao(AdminRegistrationDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean uploadFile(User user) {
		return dao.uploadFile(user);
	}

}
