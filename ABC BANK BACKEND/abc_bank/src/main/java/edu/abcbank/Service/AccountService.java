package edu.abcbank.Service;

import java.math.BigInteger;

import org.hibernate.Transaction;

import edu.abcbank.model.Account;

public interface AccountService {
	public Object getAccountdetailsById(BigInteger accountNumber);
	public Object getTransactiondetailsById(BigInteger accountNumber);
	

}
