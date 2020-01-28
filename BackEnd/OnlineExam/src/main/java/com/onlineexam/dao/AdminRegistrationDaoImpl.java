package com.onlineexam.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.onlineexam.model.User;

@Repository
public class AdminRegistrationDaoImpl implements AdminRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;
	// private static final String INSERT_USER_REGISTRATION = "INSERT INTO
	// USER_REGISTRATION(user_id,first_name,last_name,email,
	// mobile,date_of_birth,city,state,qualification,year_of_completion) "
	// + "values(";

	public AdminRegistrationDaoImpl() {
	}
	@Override
	public boolean uploadFile(User user) {
		// TODO Auto-generated method stub
		return false;
	}


}
