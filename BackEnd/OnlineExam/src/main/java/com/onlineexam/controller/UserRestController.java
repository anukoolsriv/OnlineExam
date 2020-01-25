package com.onlineexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.model.Exam;
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

	// http://localhost:9090/user/
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addUser(@RequestBody User user) {
		Boolean result = service.addUser(user);
		ResponseEntity<Response> response;
		Response res = new Response<>();
		if (result) {
			response = new ResponseEntity<>(res, HttpStatus.CREATED);
			
			
			res.setResponseCode(200);
			res.setResponseMessage("Success");
//			res.setResponseObject("User Inserted");
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

	// http://localhost:9090/user/fetch
	@RequestMapping(path = "/fetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
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

	@RequestMapping(path = "/fetchExams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> fetchExams() {
		List<Exam> exams = service.fetchExams();
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

	// @RequestMapping(path="sendMail", method = RequestMethod.GET)
	// public String sendMail(){
	//// Functions.sendEmail();
	// return "Hello World";
	// }
	//
	// @Autowired
	// private StudentService service;
	//
	// // http://localhost:9090/students
	// @RequestMapping(method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE) // JSON
	// // XML??
	// public List<Student> findAllStudents() {
	// List<Student> students = service.getAllStudents();
	//
	// return students;
	// }
	//
	// // http://localhost:9090/students/100
	// @RequestMapping(path = "{rollNumber}", method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// public Student findStudentByRollNumber(@PathVariable("rollNumber") int
	// rollNumber) {
	// Student student = service.findStudentByRollNumber(rollNumber);
	// return student;
	// }
	//
	// // http://localhost:9090/students
	// @RequestMapping(method = RequestMethod.POST, consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<String> addStudent(@RequestBody Student student) {
	// ResponseEntity<String> response;
	// boolean result=service.addStudent(student);
	// if(result){
	// response=new ResponseEntity<String>("Student is
	// added",HttpStatus.CREATED);
	// }else{
	// response=new ResponseEntity<String>("Student is not
	// added",HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	// return response;
	// }
	// @ExceptionHandler(Exception.class)
	// public ResponseEntity<String> handleException(Exception ex){
	// ResponseEntity<String> error=new
	// ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	// return error;
	// }
	//
	// // http://localhost:9090/students/
	// @RequestMapping(path = "{rollno}", method = RequestMethod.DELETE,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// public void deleteStudent(@PathVariable("rollno") int rollNumber) {
	// service.deleteStudent(rollNumber);
	// }
	//
	// // http://localhost:9090/students
	// @RequestMapping(path = "update", method = RequestMethod.POST, consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// public void updateStudent(@RequestBody Student student) {
	// service.updateStudent(student);
	// }

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ResponseEntity<String> error = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}
}
