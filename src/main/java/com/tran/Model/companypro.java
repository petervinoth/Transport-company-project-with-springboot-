package com.tran.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="companypro")

public class companypro {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Companyname")
	private String company_name;
	
	@Column(name="companylicence")
	private String company_Id;
	
	@Column(name="companyNo")
	private String phoneNo;
	
	@Column(name="product")
	private String product;
	
	 @Temporal(TemporalType.DATE)
	   
	    private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_Id() {
		return company_Id;
	}

	public void setCompany_Id(String company_Id) {
		this.company_Id = company_Id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	 
	 

}
