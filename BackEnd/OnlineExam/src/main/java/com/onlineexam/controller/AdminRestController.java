package com.onlineexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.model.Response;
import com.onlineexam.model.User;
import com.onlineexam.service.AdminRegistrationService;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin
public class AdminRestController {

	@Autowired
	private AdminRegistrationService service;

	@RequestMapping(path = "uploadFile", method = RequestMethod.POST)
	public String uploadFile() {
		return "String";
		// Boolean result = service.uploadFile(user);
		// ResponseEntity<Response> response;
		// Response res = new Response<>();
		// if (result) {
		// response = new ResponseEntity<>(res, HttpStatus.CREATED);
		//
		//
		// res.setResponseCode(200);
		// res.setResponseMessage("Success");
		// res.setResponseObject("File uploaded");
		// // response=new ResponseEntity<String>("User
		// // Added",HttpStatus.CREATED);
		// } else {
		// response = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
		// res.setResponseCode(400);
		// res.setResponseMessage("File Not Uploaded");
		// res.setResponseObject("Upload Failed");
		// // response=new ResponseEntity<String>("User Not
		// // Added",HttpStatus.INTERNAL_SERVER_ERROR);
		// }
		// return response;
	}
}
