package com.mindtree.orchard.college.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mindtree.orchard.college.entity.College;
import com.mindtree.orchard.college.service.CollegeImpl;

@WebMvcTest(value = CollegeController.class)
@WithMockUser
public class CollegeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
//	@InjectMocks
//	private CollegeController collegeController;
	
	@Mock
	private CollegeImpl collegeImpl;
	
	List<College> collegeList = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
//		mockMvc = MockMvcBuilders.standaloneSetup(collegeController).build();
		this.collegeList.add(new College(1,"IIT",0));
//		this.collegeList.add(new College(2,"CIT",0));
//		this.collegeList.add(new College(3,"SIT",0));
	}
	
	@Test
	public void getAllCollge() throws Exception {
		Mockito.when(collegeImpl.getAllCollege()).thenReturn(this.collegeList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/all").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"clgId\":\1\",\"clgName\":\"IIIT\",\"totalStudents\":\"0\"}";


		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
