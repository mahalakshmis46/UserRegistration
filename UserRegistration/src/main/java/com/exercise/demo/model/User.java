package com.exercise.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


@Entity
public class User {
	@NotNull(message="Please provide username")
	@NotBlank(message="Username must not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9]*$",message="Username must not have spaces")
	private String userName;
	
	@NotNull(message="Please provide password")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{4,}$",message="Password must be of minimum 4 characters with one Upper case letter, one Lower case letter and a number")
	private String password;
	
	@NotNull(message="Please provide date of birth")
	@Past(message = "Date of birth must be a past date")
	private LocalDate dateOfBirth;
	@NotNull
	
	@Id
	@NotNull(message="Please provide ssn")
	@Pattern(regexp = "^[0-9]*$",message="SSN invalid")
	private String ssn;
	
	public User() {}
	public User(String userName,String password,LocalDate dateOfBirth,String ssn) {
		this.userName=userName;
		this.password=password;
		this.dateOfBirth=dateOfBirth;
		this.ssn=ssn;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return "User [Name="+userName +" password="+password+" Date of birth="+dateOfBirth+" SSN="+ssn+"]";
	}
	

}
