package edu.abcbank.Controller;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import edu.abcbank.Service.ChequebookService;
import edu.abcbank.model.Chequebook;

@RestController
@CrossOrigin
public class ChequebookController {
	
	@Autowired
	private ChequebookService chequebookService;
	
	@RequestMapping(value="/saveChequebook",method=RequestMethod.POST)
	public Object insertChequebookdetails(@RequestBody Chequebook chequebook)
	{
		return (chequebookService.insertChequebookdetails(chequebook));
		
	}

	/*@RequestMapping(value="/getChequebookdetailsByreqidandaccno",method=RequestMethod.GET)
	public Object fetchTransactionByAccNo(@RequestBody Chequebook chequebook) {
		return (chequebookService.getChequebookdetailsByreqidandaccno(chequebook));
		
	}*/
	
	@RequestMapping(value="/getChequebookdetailsByreqidandaccno",method=RequestMethod.POST)
	public Object fetchTransactionByAccNo(@RequestBody Map<String, Object> chequeDetails)  {
		int reqId=(int) chequeDetails.get("requestid");
		long accNo=(long) chequeDetails.get("accountNumber");
		//System.out.println(reqId+"--"+accNo);
		//return null;
		return (chequebookService.getChequebookdetailsByreqidandaccno(reqId,accNo));
		
	}
}
