package edu.abcbank.ServiceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.Repository.StolenOrLostRepo;
import edu.abcbank.Service.StolenOrLostService;
import edu.abcbank.model.Chequebook;
import edu.abcbank.model.StolenOrLost;

@Service
public class StolenOrLostServiceImpl implements StolenOrLostService{
	
@Autowired
private StolenOrLostRepo stolenOrLostRepo;

@Transactional
@Override
public Object insertStolenOrLostdetails(StolenOrLost stolenOrLost) {
	// TODO Auto-generated method stub
	Map<String,Object> map = new HashMap<String,Object>();
	if(stolenOrLost.getRequest_Date()==null)
	{
		map.put("Status", "Error");
		map.put("msg", "please enter the requestdate");
	}
	else if(stolenOrLost.getStolen_Date()==null) { 
		map.put("Status", "Error");
		map.put("msg", "please enter the stolentdate");
	}
	else if (stolenOrLost.getResponse_Status().isEmpty()){
		map.put("Status", "Error");
		map.put("msg", "please enter the responestatus");
	}
	else{
		stolenOrLostRepo.save(stolenOrLost);
		map.put("Status", "Success");
	map.put("msg","Data Saved");
	}
	
	return map;
}

@Transactional
@Override
public Object getStolenOrLostdetailsByreqidandaccno(int reqId, long accNo) {
	// TODO Auto-generated method stub
	List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
	BigInteger accvalue = BigInteger.valueOf(accNo);
	List<StolenOrLost> stolenOrLosts = stolenOrLostRepo.getInfobyReqidandAccno(reqId,accvalue);
	for(StolenOrLost s:stolenOrLosts)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("stolenrequest_Id",s.getStolenrequest_Id());
		map.put("stolen_Date",s.getStolen_Date());
		map.put("responsestatus",s.getResponse_Status());
		map.put("requestdate",s.getRequest_Date());
		map.put("responsedate",s.getResponse_Date());
		map.put("responsemessage",s.getResponse_Message());
		map.put("accountNumber",s.getAccount3().getAccountNumber() );
		map.put("requestid",s.getServicerequest().getRequestid());
		list.add(map);
	}
	return list;
}


}

