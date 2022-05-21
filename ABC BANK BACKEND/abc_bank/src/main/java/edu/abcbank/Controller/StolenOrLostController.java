package edu.abcbank.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.Service.StolenOrLostService;
import edu.abcbank.model.Chequebook;
import edu.abcbank.model.StolenOrLost;

@RestController
@CrossOrigin
public class StolenOrLostController {
	
	@Autowired
	private StolenOrLostService stolenOrLostService;
	
	@RequestMapping(value="/savestolenOrLost",method=RequestMethod.POST)
	public Object insertStolenOrLostdetails(@RequestBody StolenOrLost stolenOrLost)
	{
		return (stolenOrLostService.insertStolenOrLostdetails(stolenOrLost));
		
	}
	

	@RequestMapping(value="/getStolenOrLostdetailsByreqidandaccno",method=RequestMethod.POST)
	public Object getStolenOrLostdetailsByreqidandaccno(@RequestBody Map<String, Object> StolenOrLost)  {
		int reqId=(int) StolenOrLost.get("requestid");
		long accNo=(long) StolenOrLost.get("accountNumber");
		return (stolenOrLostService.getStolenOrLostdetailsByreqidandaccno(reqId,accNo));
		
	}
	
}
