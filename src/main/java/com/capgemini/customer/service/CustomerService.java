package com.capgemini.customer.service;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exeption.CustomerNotFoundException;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException;
	
	public  void deleteCustomer(Customer customer);
	

}
