package edu.abcbank.Service;


import edu.abcbank.model.Chequebook;

public interface ChequebookService {
	
	
	public Object insertChequebookdetails(Chequebook chequebook);
	//public Object getChequebookdetailsByreqidandaccno(Chequebook chequebook);
	public Object getChequebookdetailsByreqidandaccno(int reqId, long accNo);
}
