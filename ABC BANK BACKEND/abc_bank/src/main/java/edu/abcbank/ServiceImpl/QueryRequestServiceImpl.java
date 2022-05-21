package edu.abcbank.ServiceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.Repository.QueryRequestRepo;
import edu.abcbank.Service.QueryRequestService;
import edu.abcbank.model.Chequebook;
import edu.abcbank.model.QueryRequest;
import edu.abcbank.model.StolenOrLost;

@Service
public class QueryRequestServiceImpl implements QueryRequestService {
	
	@Autowired
	private QueryRequestRepo queryRequestRepo;

	@Transactional
	@Override
	public Object insertQueryRequestServicedetails(QueryRequest queryRequest) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(queryRequest.getQuerydate()==null) {
			map.put("Status", "Error");
      		map.put("msg", "please enter the querydate");
		}else if(queryRequest.getResponsestatus().isEmpty()){
			map.put("Status", "Error");
      		map.put("msg", "please enter the responsestatus");
		}else if(queryRequest.getUserquery().isEmpty()) {
			map.put("Status", "Error");
      		map.put("msg", "please enter the userquery");
		}else{
			queryRequestRepo.save(queryRequest);
			map.put("Status", "Success");
		map.put("msg","Data Saved");
		}
		return map ;
	}

	@Transactional
	@Override
	public Object getQueryRequestdetailsByreqidandaccno(int reqId, long accNo) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		BigInteger accvalue = BigInteger.valueOf(accNo);
		List<QueryRequest> queryRequests = queryRequestRepo.getInfobyReqidandAccno(reqId,accvalue);
		for(QueryRequest q:queryRequests) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("queryrequestid", q.getQueryrequestid());
		map.put("userquery", q.getUserquery());
		map.put("requestdate", q.getQuerydate());
		map.put("responsedate", q.getResponsedate());
		map.put("responsemessage", q.getResponsemessage());
		map.put("responsestatus", q.getResponsestatus());
		map.put("accountNumber", q.getAccount5().getAccountNumber());
		map.put("requestid", q.getServicerequest2().getRequestid());
		list.add(map);
		}
		return list;
	}


}






