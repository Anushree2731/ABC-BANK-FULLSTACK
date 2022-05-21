package edu.abcbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import edu.abcbank.Service.CustomerService;
import edu.abcbank.model.Customer;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	private Customer customer;
	
    @RequestMapping(value="/getcustomer/{id}",method=RequestMethod.GET)	
	public Object customerdetailById(@PathVariable int id)
	{
    	return(customerService.getcustomerdetailsById(id));
	}
    
    @RequestMapping(value="/updatecustomer",method=RequestMethod.PUT)
	public Object updatecustomerdetails(@RequestBody Customer customer)
	{
		return (customerService.updatecustomerdetails(customer));
		
	}
}
    
