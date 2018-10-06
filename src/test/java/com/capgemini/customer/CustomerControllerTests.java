package com.capgemini.customer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTests {
	
	@InjectMocks
	private CustomerController customerController;
	
	@Mock
	private CustomerService customerService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
	@Test
	public void testAddCustomer() throws Exception{
		String content = "{\r\n" + 
				"  \"customerId\": \"1234\",\r\n" + 
				"  \"customerName\": \"tanu\",\r\n" + 
				"  \"email\": \"tanu123@gmail.com\",\r\n" + 
				"  \"address\": \"Hyderabad\"\r\n" + 
				"}";
		
		when(customerService.addCustomer(Mockito.isA(Customer.class))).thenReturn(new Customer(1234,"tanu","tanu123@gmail.com","Hyderabad"));
		mockMvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON).content(content).accept(MediaType.APPLICATION_JSON))
			 .andExpect(status().isOk())
			 .andExpect(jsonPath("$.customerId").exists())
			 .andExpect(jsonPath("$.customerName").exists())
			 .andExpect(jsonPath("$.email").exists())
			 .andExpect(jsonPath("$.address").exists())
			 .andDo(print());
		
	}
}
	


