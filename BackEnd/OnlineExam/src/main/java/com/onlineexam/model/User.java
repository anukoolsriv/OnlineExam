package com.onlineexam.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
@SequenceGenerator(name = "seq", sequenceName = "userid_seq", allocationSize = 1, initialValue = 1)

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobileNumber;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "year_of_completion")
	private int yearOfCompletion;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserLogin userLogin;

	@OneToMany(mappedBy = "user")
	private List<UserScore> scores;

	@OneToMany(mappedBy = "user")
	private List<CacheTable> cacheEntry;

	public User() {
		super();
	}
	
	public User(int userId, String firstName, String lastName, String email, String mobileNumber, String dateOfBirth,
			String city, String state, String qualification, int yearOfCompletion) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.state = state;
		this.qualification = qualification;
		this.yearOfCompletion = yearOfCompletion;
	}



	public User(String firstName, String lastName, String email, String mobileNumber, String dateOfBirth, String state,
			String city, String qualification, int yearOfCompletion, UserLogin userLogin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.state = state;
		this.city = city;
		this.qualification = qualification;
		this.yearOfCompletion = yearOfCompletion;
		this.setUserLogin(userLogin);

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getYearOfCompletion() {
		return yearOfCompletion;
	}

	public void setYearOfCompletion(int yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

}
