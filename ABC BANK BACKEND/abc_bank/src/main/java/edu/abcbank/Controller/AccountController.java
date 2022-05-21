package edu.abcbank.Controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.Service.AccountService;
import edu.abcbank.model.Account;

@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountService accountservice;
	
	@RequestMapping(value="/getaccountnumber/{id}",method=RequestMethod.GET)
	public Object fetchMovieById(@PathVariable BigInteger id) {
		return (accountservice.getAccountdetailsById(id));
		
	}
	
	@RequestMapping(value="/gettransactionbyAccno/{id}",method=RequestMethod.GET)
	public Object fetchTransactionByAccNo(@PathVariable BigInteger id) {
		return (accountservice.getTransactiondetailsById(id));
		
	}
}
