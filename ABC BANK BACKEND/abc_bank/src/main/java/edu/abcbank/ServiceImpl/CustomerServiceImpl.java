package edu.abcbank.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.abcbank.Repository.CustomerRepo;
import edu.abcbank.Service.CustomerService;
import edu.abcbank.model.Credentials;
import edu.abcbank.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Object getcustomerdetailsById(int Id) {
		Customer customer=customerRepo.findById(Id).orElse(null);
		if(customer!=null)
		{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("customerid",customer.getCustomerid());
		map.put("customername",customer.getCustomername());
		map.put("dateofbirth",customer.getDateofbirth());
		map.put("phone",customer.getPhone());
		map.put("address",customer.getAddress());
		map.put("city",customer.getCity());
		map.put("pincode",customer.getPincode());
		map.put("country",customer.getCountry());
		map.put("pancard",customer.getPancard());
		map.put("email",customer.getEmail());
		return map;
	}else {
		
		return Id;
         }	
	
}
	
	@Transactional
	@Override
	public Object updatecustomerdetails(Customer customer) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(customer.getAddress().isEmpty())
		{
			map.put("status","Error");
			map.put("msg", "please enter the Address ");
			
		}
		else if (customer.getCity().isEmpty()){
			map.put("status","Error");
			map.put("msg", "please enter the City ");	
		}
		
		else if (customer.getPincode()==0){
			map.put("status","Error");
			map.put("msg", "please enter the Pincode ");	
		}
		
		else if (customer.getCountry().isEmpty()) {
			map.put("status","Error");
			map.put("msg", "please enter the Country ");	
		}
		
		else if (customer.getEmail().isEmpty()) {
			map.put("status","Error");
			map.put("msg", "please enter the Email ");	
		}
		else
		{
		
			customerRepo.saveAndFlush(customer);
			map.put("status","success");
			map.put("msg", "Data saved ");
		}
		return map;
	}

}



