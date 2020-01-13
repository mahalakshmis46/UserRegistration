package com.exercise.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ExclusionServiceImpl implements ExclusionService {

	@Override
	public boolean validate(String dateOfBirth, String ssn) {

		Boolean[] inValid = {false};
		Map<String, String> excludedUsers = new HashMap<>();
		excludedUsers.put("85385075", "10th December 1815");
		excludedUsers.put("123456789", "23rd of June 1912");
		excludedUsers.put("987654321", "22nd of June 1910");

		excludedUsers.forEach((k,v) -> {
			if(k.equals(ssn) && v.equals(dateOfBirth))
				inValid[0] = true;
			
		});
		return inValid[0];
	}
}
