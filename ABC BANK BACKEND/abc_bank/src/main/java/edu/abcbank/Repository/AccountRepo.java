package edu.abcbank.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Account;
import edu.abcbank.model.Credentials;

@Repository
public interface AccountRepo extends JpaRepository<Account, BigInteger> {

}
