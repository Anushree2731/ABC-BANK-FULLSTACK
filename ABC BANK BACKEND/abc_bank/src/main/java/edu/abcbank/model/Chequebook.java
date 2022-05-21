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
@Table(name="abcbank_chequebook")
public class Chequebook {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="chequebookrequest_Id")
		private int chequebookrequest_Id;	
		
		@Column(name="noofcheque",nullable = false)
		private int noofcheque;	
		
		@Temporal(TemporalType.DATE)
		@Column(name="requestdate",nullable = false)
		private Date requestdate;
		
		@Temporal(TemporalType.DATE)
		@Column(name="responsedate")
		private Date responsedate;	
		
		@Column(name="responsemessage",length=45)
		private String responsemessage;	
		
		@Column(name="responsestatus",length=45,nullable = false)
		private String responsestatus;
		
		// Chequebook account relation
		@ManyToOne
		@JoinColumn(name="accountNumber",nullable=false)
		private Account account4;
		// Chequebook account relation
		@ManyToOne
		@JoinColumn(name="requestid",nullable=false)
		private ServiceRequest servicerequest1;
		
		public ServiceRequest getServicerequest1() {
			return servicerequest1;
		}
		public void setServicerequest1(ServiceRequest servicerequest1) {
			this.servicerequest1 = servicerequest1;
		}
		public Account getAccount4() {
			return account4;
		}
		public void setAccount4(Account account4) {
			this.account4 = account4;
		}
		public int getChequebookrequest_Id() {
			return chequebookrequest_Id;
		}
		public void setChequebookrequest_Id(int chequebookrequest_Id) {
			this.chequebookrequest_Id = chequebookrequest_Id;
		}
		public int getNoofcheque() {
			return noofcheque;
		}
		public void setNoofcheque(int noofcheque) {
			this.noofcheque = noofcheque;
		}
		public Date getRequestdate() {
			return requestdate;
		}
		public void setRequestdate(Date requestdate) {
			this.requestdate = requestdate;
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



