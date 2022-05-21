package edu.abcbank.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="abcbank_account")
public class Account {
	 
		@Id
		private BigInteger accountNumber;
		@Column(nullable = false)
		private double accountbalance;
		@Column(length = 25, nullable = false)
		private String accountType;
		@Column(length = 25, nullable = false)
		private String bankName;
		@Column(length = 25, nullable = false)
		private String branchName;
		@Column(length = 15, nullable = false)
		private String ifscCode;
		@Column(length = 25, nullable = false)
		private String location;
		
		// customer account relation
		@ManyToOne
		@JoinColumn(name="customerid",nullable=false)
		private Customer customer;
		// transaction account relation
		@OneToMany(mappedBy="account")
		private List<Transaction> transaction;
		// debit card account relation
		@OneToMany(mappedBy="account1")
		private List<Debitcard> debit;
		//Credentials account relation
		@OneToOne(mappedBy="account2")
		private Credentials credentials;
		// stlolen or lost card account relation
		@OneToMany(mappedBy="account3")
		private List<StolenOrLost> stolenorlost;
		// Chequebook account relation
		@OneToMany(mappedBy="account4")
		private List<Chequebook> chequebook;
		// Chequebook account relation
		@OneToMany(mappedBy="account5")
		private List<QueryRequest> queryrequest;
		
		
			
		
		
		public List<QueryRequest> getQueryrequest() {
			return queryrequest;
		}
		public void setQueryrequest(List<QueryRequest> queryrequest) {
			this.queryrequest = queryrequest;
		}
		public List<StolenOrLost> getStolenorlost() {
			return stolenorlost;
		}
		public void setStolenorlost(List<StolenOrLost> stolenorlost) {
			this.stolenorlost = stolenorlost;
		}
		public List<Chequebook> getChequebook() {
			return chequebook;
		}
		public void setChequebook(List<Chequebook> chequebook) {
			this.chequebook = chequebook;
		}
		public Credentials getCredentials() {
			return credentials;
		}
		public void setCredentials(Credentials credentials) {
			this.credentials = credentials;
		}
		public List<Transaction> getTransaction() {
			return transaction;
		}
		public void setTransaction(List<Transaction> transaction) {
			this.transaction = transaction;
		}
		public List<Debitcard> getDebit() {
			return debit;
		}
		public void setDebit(List<Debitcard> debit) {
			this.debit = debit;
		}
		
		public Customer getCustomer() {		
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
		public BigInteger getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(BigInteger accountNumber) {
			this.accountNumber = accountNumber;
		}
		public double getAccountbalance() {
			return accountbalance;
		}
		public void setAccountbalance(double accountbalance) {
			this.accountbalance = accountbalance;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getIfscCode() {
			return ifscCode;
		}
		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
	}

