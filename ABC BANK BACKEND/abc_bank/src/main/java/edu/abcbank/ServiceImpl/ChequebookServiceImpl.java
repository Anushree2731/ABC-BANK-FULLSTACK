package edu.abcbank.ServiceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.abcbank.Repository.ChequebookRepo;
import edu.abcbank.Service.ChequebookService;
import edu.abcbank.model.Chequebook;

@Service
public class ChequebookServiceImpl implements ChequebookService {
	
	@Autowired
	private ChequebookRepo chequebookrepo;
     
	@Transactional
	@Override
	public Object insertChequebookdetails(Chequebook chequebook) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(chequebook.getNoofcheque()==0)
		{
			map.put("Status", "Error");
			map.put("msg","please enter the noofcheque");
		}else if(chequebook.getRequestdate()==null) {
			map.put("Status", "Error");
			map.put("msg","please enter the Requestdate");
		}
	
		else if(chequebook.getResponsestatus().isEmpty()) {
			map.put("Status", "Error");
			map.put("msg","please enter the responsestatus");
		}
	
		else	{
			chequebookrepo.save(chequebook);
			map.put("Status", "Success");
			map.put("msg","Data Saved");
		}
		
		return map;
	}

	@Transactional
	@Override
	public Object getChequebookdetailsByreqidandaccno(int reqId, long accNo) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		BigInteger accvalue = BigInteger.valueOf(accNo);
		List<Chequebook> chequebooks=chequebookrepo.getInfobyReqidandAccno(reqId,accvalue);
		for(Chequebook c:chequebooks )
		{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("chequebookrequest_Id",c.getChequebookrequest_Id());
			map.put("noofcheque",c.getNoofcheque());
			map.put("requestdate",c.getRequestdate());
			map.put("responsedate",c.getResponsedate());
			map.put("responsemessage",c.getResponsemessage());
			map.put("responsestatus",c.getResponsestatus());
			map.put("accountNumber", c.getAccount4().getAccountNumber());
			map.put("requestid",c.getServicerequest1().getRequestid());
			list.add(map);
		}
		return list;
	}


}

