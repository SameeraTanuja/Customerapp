package com.capgemini.customer.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exeption.CustomerNotFoundException;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent())
			return optionalCustomer.get();
		throw new CustomerNotFoundException("customer does not exists");
	}

	@Override
	public void deleteCustomer(Customer customer) {
		
		customerRepository.delete(customer);
	}
	
	

}
