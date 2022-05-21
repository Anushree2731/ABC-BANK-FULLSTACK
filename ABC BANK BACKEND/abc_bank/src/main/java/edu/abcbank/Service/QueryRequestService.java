package edu.abcbank.Service;

import edu.abcbank.model.QueryRequest;

public interface QueryRequestService {

	public Object insertQueryRequestServicedetails(QueryRequest queryRequest);
	public Object getQueryRequestdetailsByreqidandaccno(int reqId, long accNo);
	
}
