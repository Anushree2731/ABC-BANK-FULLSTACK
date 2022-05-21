package edu.abcbank.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.Service.QueryRequestService;
import edu.abcbank.model.QueryRequest;
import edu.abcbank.model.StolenOrLost;

@RestController
@CrossOrigin
public class QueryRequestController {
	
	@Autowired
	private QueryRequestService queryRequestService;
	
	@RequestMapping(value="/savequeryRequest",method=RequestMethod.POST)
	public Object insertQueryRequestServicedetails(@RequestBody QueryRequest queryRequest)
	{
		return (queryRequestService.insertQueryRequestServicedetails(queryRequest));
		
	}
	
	@RequestMapping(value="/getQueryRequestdetailsByreqidandaccno",method=RequestMethod.POST)
	public Object getQueryRequestdetailsByreqidandaccno(@RequestBody Map<String, Object> QueryRequest)  {
		int reqId=(int) QueryRequest.get("requestid");
		long accNo=(long) QueryRequest.get("accountNumber");
		return (queryRequestService.getQueryRequestdetailsByreqidandaccno(reqId,accNo));
		
	}
	
}
