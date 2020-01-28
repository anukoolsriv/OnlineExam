package com.onlineexam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;
	// private static final String INSERT_USER_REGISTRATION = "INSERT INTO
	// USER_REGISTRATION(user_id,first_name,last_name,email,
	// mobile,date_of_birth,city,state,qualification,year_of_completion) "
	// + "values(";

	public UserRegistrationDaoImpl() {
	}

	@Override
	@Transactional
	public User addUser(User user) {
		return entityManager.merge(user);

		// int res = addUserLogin(user);
		//
		// return user1;
	}

	@Transactional
	public int addUserLogin(UserLogin userLogin) {
		entityManager.persist(userLogin);
		return 1;
	}

	@Override
	@Transactional
	public int validateLogin(UserLogin userLogin) {
		String query = "From UserLogin u where u.email = :email and u.password = :password";

		// String jqpl="SELECT u FROM UserLogin u WHERE u.email=:email and
		// u.password=:password";
		// Query query=entityManager.createQuery(jqpl);
		TypedQuery<UserLogin> typed = entityManager.createQuery(query, UserLogin.class);
		typed.setParameter("email", userLogin.getEmail());
		typed.setParameter("password", userLogin.getPassword());
		// entityManager.getTransaction().begin();
		List<UserLogin> res = typed.getResultList();

		for (UserLogin user : res) {
			System.out.println("User: " + user);
		}
		System.out.println(res.size());
		// entityManager.getTransaction().commit();
		return res.size();
	}

	@Override
	public List<Exam> getExams() {
//		String query = "SELECT e.examId, DISTINCT(e.examName) from Exam e";
		String query = "From Exam";
		System.out.println("dao");
//		TypedQuery<Exam> typed = entityManager.createQuery(query, Exam.class);
		TypedQuery<Exam> typed = entityManager.createQuery(query, Exam.class);

		List<Exam> exams = typed.getResultList();
//		System.out.println(exams.size());
		return exams;
	}

	@Override
	public List<Questions> getExamQuestions(String exam) {
		System.out.println(exam);
		String query = "Select q from Questions q, Exam e where q.exam = e and e.examName = :examName";
		TypedQuery<Questions> typed = entityManager.createQuery(query, Questions.class);
		typed.setParameter("examName", exam.toUpperCase());
		
		List<Questions> questions = typed.getResultList();
		System.out.println(questions);
		return questions;
	}

	@Override
	public int validateAnswer(int questionId, String answerGiven) {
//		System.out.println(questionId + "/" + answerGiven);
		String query = "From Questions q where q.questionId = :questionId and q.correctAnswer= :answerGiven";
		TypedQuery<Questions> typed = entityManager.createQuery(query,Questions.class);
		typed.setParameter("questionId", questionId);
		typed.setParameter("answerGiven", answerGiven);
		
		List<Questions> questions = typed.getResultList();
		return questions.size();
	}

}
