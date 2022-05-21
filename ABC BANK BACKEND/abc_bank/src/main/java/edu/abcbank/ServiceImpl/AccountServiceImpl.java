package edu.abcbank.ServiceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.abcbank.Repository.AccountRepo;
import edu.abcbank.Repository.CustomerRepo;
import edu.abcbank.Service.AccountService;
import edu.abcbank.model.Account;
import edu.abcbank.model.Transaction;

@Service
public class AccountServiceImpl implements  AccountService {

	@Autowired
	private AccountRepo accountrepo;

	@Transactional
	@Override
	public Object getAccountdetailsById(BigInteger accountNumber) {
		
		System.out.println(accountNumber);
		Account account1 = accountrepo.findById(accountNumber).orElse(null);
		Map<String,Object> map=new HashMap<String,Object>();
		if(account1!=null)
		{
			map.put("accountNumber",account1.getAccountNumber());
			map.put("accountbalance",account1.getAccountbalance());
			map.put("accountType",account1.getAccountType());
			map.put("bankName",account1.getBankName());
			map.put("branchName",account1.getBranchName());
			map.put("ifscCode",account1.getIfscCode());
			map.put("averagebalance",account1.getAccountbalance()/5);
			//System.out.println(account1.getTransaction().size());
		}else {
			map.put("status", "error");
			map.put("msg", "no details found with this accountnumber");
		}
		return map;
	}

	@Transactional
	@Override
	public Object getTransactiondetailsById(BigInteger accountNumber) {
		Account account1 = accountrepo.findById(accountNumber).orElse(null);
		List<Map<String, Object>> list=new ArrayList<>();
		List<Transaction> list1=account1.getTransaction();
		double closingBal=0;
		for(Transaction t:list1)
		{
			Map<String, Object> map=new HashMap<>();
			map.put("transactionId", t.getTranscationId());
			map.put("transcationDate", t.getTranscationDate());
			map.put("description",t.getDescription());
			map.put("creditordebit",t.getCreditordebit());
			map.put("transcationamount",t.getTranscationamount());
			
			if(t.getCreditordebit().equals("Credit"))
			{
				closingBal=closingBal+t.getTranscationamount();
			}else
			{
				closingBal=closingBal-t.getTranscationamount();
			}
			map.put("closingBalance",closingBal);
			list.add(map);
		}
		return list;
	}

	
}



	