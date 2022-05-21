package edu.abcbank.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import edu.abcbank.model.StolenOrLost;

@Repository
public interface StolenOrLostRepo extends JpaRepository<StolenOrLost, Integer> {

	@Query("select s from StolenOrLost s where s.servicerequest.requestid=:requestid and s.account3.accountNumber=:accountNumber")
	List<StolenOrLost> getInfobyReqidandAccno(@Param ("requestid") int requestid ,@Param ("accountNumber") BigInteger accountNumber);

}
