package com.onlineexam.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.dao.UserRegistrationDao;
import com.onlineexam.functions.Functions;
import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.User;
import com.onlineexam.model.UserAnswer;
import com.onlineexam.model.UserLogin;
import com.onlineexam.model.UserScore;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationDao dao;

	public UserRegistrationDao getDao() {
		return dao;
	}

	public void setDao(UserRegistrationDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean addUser(User user) {
		String OTP = Functions.generatePassword();

		System.out.println("OTP " + OTP);
		// set userLogin credentials
//		UserLogin userLogin = new UserLogin(user.getUserId(), user.getEmail(), OTP);

//		user.setUserLogin(userLogin);
//		user.getUserLogin().setEmail(user.getEmail());

		System.out.println(user);

		User u1 = dao.addUser(user);
//		System.out.println("Added " + isAdded);
		System.out.println("User Id " + u1.getUserId());
		boolean finalStatus = false;
		boolean mailSent = false;
		if (u1 != null) {
			UserLogin userLogin = new UserLogin(u1.getUserId(), u1.getEmail(), OTP);
			int insertUserLogin = dao.addUserLogin(userLogin);
			if (insertUserLogin == 1) {
				mailSent = Functions.sendEmail(user.getEmail(), OTP);
			}
			if (mailSent) {
				finalStatus = true;
			}
		}
		return finalStatus;
	}
//	
//	private boolean insertuserLogin(char[] OTP, String email) {
//		int insert = dao.insertPassword(OTP, email);
//		
//		if(insert == 1){
//			return true;
//		}
//		return false;
//	}

	/*
	 * public boolean updatePassword(char[] OTP, String email){ int updated =
	 * dao.updatePassword(OTP, email);
	 * 
	 * if(updated == 1){ return true; } return false;
	 * 
	 * }
	 */

	@Override
	public boolean validateLogin(UserLogin userLogin) {
		int result = dao.validateLogin(userLogin);

		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Set<Exam> fetchExams() {
		List<Exam> examsList = dao.getExams();
		HashSet<Exam> examSet = new HashSet<Exam>();

//		System.out.println("List");
//		exam.equals(exams);
		for(Exam e : examsList){
			examSet.add(e);
		}
		System.out.println("service");
		
//		System.out.println("Set");
		for(Exam e : examSet){
			System.out.println(e.getExamName() + " " + e.getExamId());
		}
		
		return examSet;
	}

	@Override
	public List<Questions> getExamQuestions(String exam) {
		
		return dao.getExamQuestions(exam);
	}

	@Override
	public boolean validateAnswer(int questionId, String answerGiven) {
		int result = dao.validateAnswer(questionId, answerGiven);

		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addScore(UserAnswer userAnswer) {
		
		User user = dao.fetchUserId(userAnswer.getUserEmail());
		Exam exam = dao.fetchExamId(userAnswer.getExamName());
		
		UserScore userScore = new UserScore();
		userScore.setUser(user);
		userScore.setExam(exam);
		userScore.setScorePerAttempt(userAnswer.getScore());
		userScore.setDateOfExam(userAnswer.getDateOfExam());
		userScore.setTimeTaken(userAnswer.getTimeTaken());
		
		int result = dao.addScore(userScore);

		if (result == 1) {
			return true;
		}
		return false;
	}

}
