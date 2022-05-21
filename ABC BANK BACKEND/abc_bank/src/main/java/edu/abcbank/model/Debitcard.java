package edu.abcbank.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="abcbank_debitcard")

public class Debitcard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="debit_id")
	private int debit_id;
	@Column(name="debitcardnumber",length=16,nullable= false)
	private int debitcardnumber;
	@Column(name="pinnumber",length=10,nullable= false)
	private int pinnumber;
	@Column(name="expirydate")
	@Temporal(TemporalType.DATE)
	private Date expirydate;
	@Column(name="cvv",length=3,nullable= false)
	private int cvv;
	// debit card account relation
	@ManyToOne
	@JoinColumn(name="accountNumber")
	private Account account1;
	


	
	public Account getAccount1() {
		return account1;
	}
	public void setAccount1(Account account1) {
		this.account1 = account1;
	}
	public int getDebit_id() {
	return debit_id;
	}
	public int getDebitcardnumber() {
	return debitcardnumber;
	}
	public int getPinnumber() {
	return pinnumber;
	}
	public Date getExpirydate() {
	return expirydate;
	}
	public int getCvv() {
	return cvv;
	}
	public void setDebit_id(int debit_id) {
	this.debit_id = debit_id;
	}
	public void setDebitcardnumber(int debitcardnumber) {
	this.debitcardnumber = debitcardnumber;
	}
	public void setPinnumber(int pinnumber) {
	this.pinnumber = pinnumber;
	}
	public void setExpirydate(Date expirydate) {
	this.expirydate = expirydate;
	}
	public void setCvv(int cvv) {
	this.cvv = cvv;
	}

	}




