package com.exercise.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.demo.dao.UserRepository;
import com.exercise.demo.exception.ResourceNotFoundException;
import com.exercise.demo.exception.UserAlreadyPresentException;
import com.exercise.demo.exception.UserIsExcludedException;
import com.exercise.demo.model.User;

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/users")
	public List<User> getUsers() {

		return (List<User>) userRepo.findAll();

	}

	@GetMapping("/user/{ssn}")
	public User getUser(@PathVariable String ssn) throws ResourceNotFoundException {

		return userRepo.findById(ssn).orElseThrow(() -> new ResourceNotFoundException("User not found:" + ssn));
	}

	@PostMapping("/user")
	public User createUser(@RequestBody @Valid User user) throws UserAlreadyPresentException, UserIsExcludedException {
		
		String dob = convertDobToString(user.getDateOfBirth());
		boolean userExists = userRepo.findById(user.getSsn()).isPresent();

		if (userRepo.validate(dob, user.getSsn())) {
			 throw new UserIsExcludedException("User is not allowed:" + user.getSsn());
			 }
		
		if (userExists)
			throw new UserAlreadyPresentException("User has been registered already :" + user.getSsn());

		
		

		return userRepo.save(user);
	}

	private String convertDobToString(LocalDate dateOfBirth) {
		String dateString;
		Map<Long, String> ordinalNumbers = new HashMap<>(42);
		ordinalNumbers.put(1L, "1st");
		ordinalNumbers.put(2L, "2nd");
		ordinalNumbers.put(3L, "3rd");
		ordinalNumbers.put(21L, "21st");
		ordinalNumbers.put(22L, "22nd");
		ordinalNumbers.put(23L, "23rd");
		ordinalNumbers.put(31L, "31st");
		for (long d = 1; d <= 31; d++) {
			ordinalNumbers.putIfAbsent(d, "" + d + "th");
		}

		DateTimeFormatter dayOfMonthFormatter = new DateTimeFormatterBuilder()
				
				.appendText(ChronoField.DAY_OF_MONTH, ordinalNumbers)
				.appendLiteral(" of")
				.appendPattern(" MMMM ")
				.appendText(ChronoField.YEAR).toFormatter();

		LocalDate date = dateOfBirth;
		dateString = date.format(dayOfMonthFormatter);
		

		return dateString;
	}

}
