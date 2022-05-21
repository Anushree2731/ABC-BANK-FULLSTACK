package edu.abcbank.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Chequebook;
import edu.abcbank.model.Credentials;

@Repository
public interface ChequebookRepo extends JpaRepository<Chequebook, Integer> {

	@Query("select c from Chequebook c where c.servicerequest1.requestid=:requestid and c.account4.accountNumber=:accountNumber")
	List<Chequebook> getInfobyReqidandAccno(@Param ("requestid") int  requestid , @Param("accountNumber") BigInteger accountNumber);

	

}
