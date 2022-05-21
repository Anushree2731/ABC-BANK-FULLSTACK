package edu.abcbank.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.QueryRequest;
import edu.abcbank.model.StolenOrLost;

@Repository
public interface QueryRequestRepo extends JpaRepository<QueryRequest, Integer>{


	@Query("select q from QueryRequest q where q.servicerequest2.requestid=:requestid and q.account5.accountNumber=:accountNumber")
	List<QueryRequest> getInfobyReqidandAccno(@Param ("requestid") int requestid ,@Param ("accountNumber") BigInteger accountNumber);

}
