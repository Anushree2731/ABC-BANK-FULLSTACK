package edu.abcbank.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="abcbank_queryrequest")
public class QueryRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Queryrequestid")
	private int queryrequestid;
	@Column(name="Userquery",length=45,nullable=false)
	private String userquery;
	@Temporal(TemporalType.DATE)
	@Column(name="Querydate",nullable=false)
	private Date querydate;
	@Temporal(TemporalType.DATE)
	@Column(name="Responsedate",nullable=true)
	private Date responsedate;
	@Column(name="Responsemessage",length=45,nullable=true)
	private String responsemessage;
	@Column(name="Responsestatus",length=45,nullable=false)
	private String responsestatus;
	
	// QueryRequest account relation
	@ManyToOne
	@JoinColumn(name="accountNumber",nullable=false)
	private Account account5;
	
	// QueryRequest ServiceRequest relation
	@ManyToOne
	@JoinColumn(name="requestid",nullable=false)
	private ServiceRequest servicerequest2;
	
	
	public ServiceRequest getServicerequest2() {
		return servicerequest2;
	}
	public void setServicerequest2(ServiceRequest servicerequest2) {
		this.servicerequest2 = servicerequest2;
	}
	public Account getAccount5() {
		return account5;
	}
	public void setAccount5(Account account5) {
		this.account5 = account5;
	}
	public int getQueryrequestid() {
	return queryrequestid;
	}
	public void setQueryrequestid(int queryrequestid) {
	this.queryrequestid = queryrequestid;
	}
	public String getUserquery() {
	return userquery;
	}
	public void setUserquery(String userquery) {
	this.userquery = userquery;
	}
	public Date getQuerydate() {
	return querydate;
	}
	public void setQuerydate(Date querydate) {
	this.querydate = querydate;
	}
	public Date getResponsedate() {
	return responsedate;
	}
	public void setResponsedate(Date responsedate) {
	this.responsedate = responsedate;
	}
	public String getResponsemessage() {
	return responsemessage;
	}
	public void setResponsemessage(String responsemessage) {
	this.responsemessage = responsemessage;
	}
	public String getResponsestatus() {
	return responsestatus;
	}
	public void setResponsestatus(String responsestatus) {
	this.responsestatus = responsestatus;
	
	}

}

	

