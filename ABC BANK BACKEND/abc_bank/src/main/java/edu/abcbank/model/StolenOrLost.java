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
@Table(name="abcbank_stolenorlost")
public class StolenOrLost {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="stolenrequest_Id")
		private int stolenrequest_Id;
		
		@Column(name="stolen_Date",nullable = false)
		@Temporal(TemporalType.DATE)
		private Date stolen_Date;
		
		@Column(name="response_Status", length = 45,nullable = false)
		private String response_Status;
		
		@Column(name="request_Date",nullable = false)
		@Temporal(TemporalType.DATE)
		private Date request_Date;
		
		
		@Column(name="response_Date")
		@Temporal(TemporalType.DATE)
		private Date response_Date;
		
		@Column(name="response_Message", length = 45)
		private String response_Message;
		
		//stolen or lost account relation
		@ManyToOne
		@JoinColumn(name="accountNumber",nullable=false)
		private Account account3;
		public ServiceRequest getServicerequest() {
			return servicerequest;
		}
		public void setServicerequest(ServiceRequest servicerequest) {
			this.servicerequest = servicerequest;
		}
		
		//stolen or lost ServiceRequest relation
		@ManyToOne
		@JoinColumn(name="requestid",nullable=false)
		private ServiceRequest servicerequest;
	
		public Account getAccount3() {
				return account3;
			}
			public void setAccount3(Account account3) {
				this.account3 = account3;
			}
		public int getStolenrequest_Id() {
			return stolenrequest_Id;
		}
		public void setStolenrequest_Id(int stolenrequest_Id) {
			this.stolenrequest_Id = stolenrequest_Id;
		}
		public Date getStolen_Date() {
			return stolen_Date;
		}
		public void setStolen_Date(Date stolen_Date) {
			this.stolen_Date = stolen_Date;
		}
		public String getResponse_Status() {
			return response_Status;
		}
		public void setResponse_Status(String response_Status) {
			this.response_Status = response_Status;
		}
		public Date getRequest_Date() {
			return request_Date;
		}
		public void setRequest_Date(Date request_Date) {
			this.request_Date = request_Date;
		}
		public Date getResponse_Date() {
			return response_Date;
		}
		public void setResponse_Date(Date response_Date) {
			this.response_Date = response_Date;
		}
		public String getResponse_Message() {
			return response_Message;
		}
		public void setResponse_Message(String response_Message) {
			this.response_Message = response_Message;
		}
		
	}


