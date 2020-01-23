package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_login")

public class UserLogin {
	@Id
	@Column(name = "user_id")
	private int userId;


	@Column(name = "email")
	private String email;


	@Column(name = "password")
	private String password;

	@Column(name = "otp")
	private String otp;

	@OneToOne(mappedBy = "userLogin")
	private User user;

	public UserLogin() {
		super();
	}

	public UserLogin(int userId, String email, String password, String otp) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.otp = otp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
