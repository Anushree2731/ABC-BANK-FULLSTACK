package edu.abcbank.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.Repository.CredentialsRepo;
import edu.abcbank.Service.CredentialsService;
import edu.abcbank.model.Credentials;

@Service
public class CredentialsServiceImpl implements CredentialsService{

	@Autowired
	private CredentialsRepo credentialsrepo;

	@Transactional
	@Override
	public Object isUserLogin(Credentials credentials) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		Credentials credentials2=credentialsrepo.checkUser(credentials.getUsername(),credentials.getPassword());
		if(credentials2!=null)
		{
			map.put("status", "success");
			map.put("Msg", "Loggedin");
			map.put("accountNo", credentials2.getAccount2().getAccountNumber());
			map.put("customerId", credentials2.getAccount2().getCustomer().getCustomerid());
			map.put("customerName", credentials2.getAccount2().getCustomer().getCustomername());
		}else
		{
			map.put("status", "error");
			map.put("Msg", "username and password not exist");
		}
		
		return map;
	}

}

