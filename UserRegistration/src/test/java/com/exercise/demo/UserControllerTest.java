package com.exercise.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;



@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

	@Autowired
	protected MockMvc mockMvc;
	
		
	String exampleUserJsonSuccess = "{\"userName\":\"TestUser\",\"password\":\"Tlk57\",\"dateOfBirth\":\"1911-06-22\",\"ssn\":\"987654321\"}";
	String exampleUserJsonExcluded = "{\"userName\":\"TestUser\",\"password\":\"Tlk57\",\"dateOfBirth\":\"1910-06-22\",\"ssn\":\"987654321\"}";
	String exampleUserJsonInvalid = "{\"userName\":\"Test User\",\"password\":\"Tlk57\",\"dateOfBirth\":\"1911-06-22\",\"ssn\":\"987654321\"}";
	

	@Test
	public void createUserTestSuccess() throws Exception
	{
		
	   this.mockMvc.perform( MockMvcRequestBuilders
			  .post("/userService/user")
	      .content(exampleUserJsonSuccess)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful())
	      .andDo(MockMvcResultHandlers.print());

	}
	@Test
	public void createUserTestExcluded() throws Exception
	{
		
	   this.mockMvc.perform( MockMvcRequestBuilders
			  .post("/userService/user")
	      .content(exampleUserJsonExcluded)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isForbidden())
	      .andDo(MockMvcResultHandlers.print());

	}
	@Test
	public void createUserTestInvlaid() throws Exception
	{
		
	   this.mockMvc.perform( MockMvcRequestBuilders
			  .post("/userService/user")
	      .content(exampleUserJsonInvalid)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isBadRequest())
	      .andDo(MockMvcResultHandlers.print());

	}
	
	 
	

}