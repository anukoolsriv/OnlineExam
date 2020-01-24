package com.onlineexam.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;
//	private static final String INSERT_USER_REGISTRATION = "INSERT INTO USER_REGISTRATION(user_id,first_name,last_name,email, mobile,date_of_birth,city,state,qualification,year_of_completion) "
//			+ "values(";

	public UserRegistrationDaoImpl() {
	}

	@Override
	@Transactional
	public User addUser(User user) {
		return entityManager.merge(user);
		
//		int res = addUserLogin(user);
//		
//		return user1;
	}

	@Override
	public int insertPassword(char[] OTP, String email) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional
	public int addUserLogin(UserLogin userLogin){
		entityManager.persist(userLogin);
		return 1;
	}

//	@Override
//	@Transactional
//	public int updatePassword(char[] OTP, String email) {
//		String sql = "Update UserLogin u set u.password = :password where u.email= :email";
//		Query query = entityManager.createQuery(sql);
//		query.setParameter("password", new String(OTP));
//		query.setParameter("email", email);
//		
//		int updated = query.executeUpdate();
//		System.out.println("updated " + updated);
//		return updated;
//				
//	}

}
