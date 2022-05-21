package edu.abcbank.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="abcbank_customer")
public class Customer {

	@Id
	@Column(name="customerid")
		private int customerid;
	@Column(name="customername",length=45,nullable=false)
		private String customername;
	@Temporal(TemporalType.DATE)
	@Column(name="dateofbirth",nullable=false)
		private Date dateofbirth;
	@Column(name="phone",length=10,nullable=false)
		private BigInteger phone;
	@Column(name="address",length=45,nullable=false)
		private String address;
	@Column(name="city",length=20,nullable=false)
		private String city;
	@Column(name="pincode",nullable=false)
		private int pincode;
	@Column(name="country",length=20,nullable=false)
		private String country;
	@Column(name="pancard",length=45)
		private String pancard;
	@Column(name="email",length=45)
		private String email;

	// customer account relation
	@OneToMany(mappedBy="customer")
	private List<Account> account;

		public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
		public int getCustomerid() {
			return customerid;
		}
		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}
		public String getCustomername() {
			return customername;
		}
		public void setCustomername(String customername) {
			this.customername = customername;
		}
		public Date getDateofbirth() {
			return dateofbirth;
		}
		public void setDateofbirth(Date dateofbirth) {
			this.dateofbirth = dateofbirth;
		}
		
		public BigInteger getPhone() {
			return phone;
		}
		public void setPhone(BigInteger phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPancard() {
			return pancard;
		}
		public void setPancard(String pancard) {
			this.pancard = pancard;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
	}



