package edu.abcbank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Credentials;
import edu.abcbank.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>  {

}
