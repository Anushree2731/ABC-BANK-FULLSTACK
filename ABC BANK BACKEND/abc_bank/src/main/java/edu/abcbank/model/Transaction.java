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
@Table(name="abcbank_transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transcationId")
	private int transcationId;
	@Column(name="transcationDate")
	@Temporal(TemporalType.DATE)
	private Date transcationDate;
	@Column(name="description",length=45,nullable= false)
	private String description;
	@Column(name="creditordebit",length=20,nullable= false)
	private String creditordebit;
	@Column(nullable = false)
	private double transcationamount;
	
    //Account transaction relation
	@ManyToOne
	@JoinColumn(name="accountNumber")
	private Account account;
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getTranscationId() {
	return transcationId;
	}
	public Date getTranscationDate() {
	return transcationDate;
	}
	public String getDescription() {
	return description;
	}
	public String getCreditordebit() {
	return creditordebit;
	}
	public void setTranscationId(int transcationId) {
	this.transcationId = transcationId;
	}
	public void setTranscationDate(Date transcationDate) {
	this.transcationDate = transcationDate;
	}
	public void setDescription(String description) {
	this.description = description;
	}
	public void setCreditordebit(String creditordebit) {
	this.creditordebit = creditordebit;
	}
	public double getTranscationamount() {
		return transcationamount;
	}
	public void setTranscationamount(double transcationamount) {
		this.transcationamount = transcationamount;
	}
	}





