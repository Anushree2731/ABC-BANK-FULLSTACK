package edu.abcbank.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.Service.CredentialsService;
import edu.abcbank.model.Credentials;

@RestController
@CrossOrigin
public class CredentialsController {


		@Autowired
		private CredentialsService credentialsService;
		
		@RequestMapping(value="/UserLogin",method=RequestMethod.POST)
		public Object isUserLogin(@RequestBody Credentials credentials)
		{
			
			return (credentialsService.isUserLogin(credentials));
			
	}
	}

