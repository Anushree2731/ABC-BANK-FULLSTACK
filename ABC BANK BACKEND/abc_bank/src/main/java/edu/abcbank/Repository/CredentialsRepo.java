package edu.abcbank.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Credentials;

@Repository
public interface CredentialsRepo extends JpaRepository<Credentials, Integer> {
		@Query("select c from Credentials c where c.username=:username and password=:password")
		Credentials checkUser(@Param("username") String username,@Param("password") String password);
		
	}


