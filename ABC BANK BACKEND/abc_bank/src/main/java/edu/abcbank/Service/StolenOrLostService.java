package edu.abcbank.Service;


import edu.abcbank.model.StolenOrLost;

public interface StolenOrLostService {
	public Object insertStolenOrLostdetails(StolenOrLost stolenOrLost);
	public Object getStolenOrLostdetailsByreqidandaccno(int reqId, long accNo);

}
