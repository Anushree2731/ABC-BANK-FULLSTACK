package edu.abcbank.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="abcbank_credentials")
public class Credentials {

	@Id
	private int credentailid;
	@Column(length=30,nullable=false)
	private String username;
	@Column(length=15,nullable=false)
	private String password;
	// Credentials card account relation
	@OneToOne
	@JoinColumn(name="accountNumber")
	private Account account2;
	

	public Account getAccount2() {
		return account2;
	}
	public void setAccount2(Account account2) {
		this.account2 = account2;
	}
	
	public int getCredentailid() {
		return credentailid;
	}
	public void setCredentailid(int credentailid) {
		this.credentailid = credentailid;
	}
	public String getUsername() {
	return username;
	}
	public void setUsername(String username) {
	this.username = username;
	}
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	}


