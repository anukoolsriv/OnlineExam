package com.onlineexam.controller;

import java.util.List;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.model.Exam;
import com.onlineexam.model.Questions;
import com.onlineexam.model.Response;
import com.onlineexam.model.User;
import com.onlineexam.model.UserLogin;
import com.onlineexam.service.UserRegistrationService;

@RestController
@RequestMapping(path = "user")
@CrossOrigin
public class UserRestController {

	@Autowired
	private UserRegistrationService service;

	//http://192.168.12.75:9090/user/register
	@RequestMapping(path="register",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addUser(@RequestBody User user) {
		Boolean result = service.addUser(user);
		ResponseEntity<Response> response;
		Response res = new Response<>();
		if (result) {
			response = new ResponseEntity<>(res, HttpStatus.CREATED);
			
			
			res.setResponseCode(200);
			res.setResponseMessage("Success");
			res.setResponseObject("User Inserted");
			// response=new ResponseEntity<String>("User
			// Added",HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
			res.setResponseCode(400);
			res.setResponseMessage("Failed");
//			res.setResponseObject("Registration Failed");
			// response=new ResponseEntity<String>("User Not
			// Added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String addUser() {
		return "Hello World";
	}

	// http://http://192.168.12.75:9090/user/login
	@RequestMapping(path = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> validateLogin(@RequestBody UserLogin userLogin) {
		boolean result = service.validateLogin(userLogin);
		ResponseEntity<Response> response;
		Response res = new Response<>();
		if (result) {
			response = new ResponseEntity<>(res, HttpStatus.CREATED);
			res.setResponseCode(200);
			res.setResponseMessage("Success");
//			res.setResponseObject("Login Successful");
		} else {
			response = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			res.setResponseCode(400);
			res.setResponseMessage("Failed");
//			res.setResponseObject("User Does Not Exist");
		}
		return response;
	}
	// http://http://192.168.12.75:9090/user/fetchExams
	@RequestMapping(path = "/fetchExams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> fetchExams() {
		Set<Exam> exams = service.fetchExams();
		ResponseEntity<Response> response;
		Response res = new Response<>();
		if (exams != null && exams.size() > 0) {
			response = new ResponseEntity<>(res, HttpStatus.CREATED);
			res.setResponseCode(200);
			res.setResponseMessage("Exams Fetched");
			res.setResponseObject(exams);
		} else {
			response = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			res.setResponseCode(400);
			res.setResponseMessage("Exam Does Not Exist");
			res.setResponseObject(null);
		}
		return response;
	}
	// http://192.168.12.75:9090/user/getQuestions/{exam}
	@RequestMapping(path="/getQuestions/{exam}")
	public ResponseEntity<Response> getExamQuestions(@PathVariable("exam") String exam){
		System.out.println(exam);
		ResponseEntity<Response> response;
		List<Question> questions = service.getExamQuestions(exam); 
		Response res = new Response<>();
		if (questions != null && questions.size() > 0) {
			response = new ResponseEntity<>(res, HttpStatus.CREATED);
			res.setResponseCode(200);
			res.setResponseMessage("Questions Fetched");
			res.setResponseObject(questions);
		} else {
			response = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			res.setResponseCode(400);
			res.setResponseMessage("Questions Could not be fetched");
			res.setResponseObject(null);
		}
		return response;
	}

	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ResponseEntity<String> error = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}
}
