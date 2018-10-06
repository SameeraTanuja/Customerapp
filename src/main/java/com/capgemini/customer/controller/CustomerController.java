package com.capgemini.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		ResponseEntity<Customer> responseEntity= new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.OK);
		
		return responseEntity;
		
	}
	
	/*@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		try
		{
		ResponseEntity<Customer>
	}*/

}

