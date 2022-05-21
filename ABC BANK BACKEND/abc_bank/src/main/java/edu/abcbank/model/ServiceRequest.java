package edu.abcbank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="abcbank_servicerequest")
public class ServiceRequest {
	

	@Id
	@Column(name="requestid")
	private int requestid;
	@Column(name="requestType",length=30,nullable=false)
	private String requesttype;
	// stlolen or lost card ServiceRequest relation
	@OneToMany(mappedBy="servicerequest")
	private List<StolenOrLost> stolenorlost;
	// Chequebook ServiceRequest relation
	@OneToMany(mappedBy="servicerequest1")
	private List<Chequebook> chequebook;
	// QueryRequest ServiceRequest relation
	@OneToMany(mappedBy="servicerequest2")
	private List<QueryRequest> queryrequest;
	
	
		
			

	public List<QueryRequest> getQueryrequest() {
		return queryrequest;
	}
	public void setQueryrequest(List<QueryRequest> queryrequest) {
		this.queryrequest = queryrequest;
	}
	public List<Chequebook> getChequebook() {
		return chequebook;
	}
	public void setChequebook(List<Chequebook> chequebook) {
		this.chequebook = chequebook;
	}
	public List<StolenOrLost> getStolenorlost() {
		return stolenorlost;
	}
	public void setStolenorlost(List<StolenOrLost> stolenorlost) {
		this.stolenorlost = stolenorlost;
	}
	public int getRequestid() {
	return requestid;
	}
	public void setRequestid(int requestid) {
	this.requestid = requestid;
	}
	public String getRequesttype() {
	return requesttype;
	}
	public void setRequesttype(String requesttype) {
	this.requesttype = requesttype;
	}
	}

	

