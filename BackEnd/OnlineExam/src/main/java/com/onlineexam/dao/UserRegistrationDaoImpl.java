package com.onlineexam.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.model.User;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public UserRegistrationDaoImpl() {
	}

	@Override
	@Transactional
	public int addUser(User user) {
		entityManager.persist(user);
		return 1;
	}

}
