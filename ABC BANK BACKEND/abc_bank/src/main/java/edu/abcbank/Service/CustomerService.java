package edu.abcbank.Service;

import edu.abcbank.model.Customer;

public interface CustomerService {
	public Object getcustomerdetailsById(int id);
	public Object updatecustomerdetails(Customer customer);
	
}
