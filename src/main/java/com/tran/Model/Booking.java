package com.tran.Model;
import javax.validation.constraints.NotNull;

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
@Table(name="Booking")
public class Booking {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="CompanyName")
	private String c_name;
	 
	@Column(name="licenceNo")
	private String comlic;
	
	@Column(name="product")
	private String product;
	  
	@Column(name="fromAddress")
	private String from_add;
	
	@Column(name="companyLocation")
	private String c_location;
	
	
	public String getC_location() {
		return c_location;
	}

	public void setC_location(String c_location) {
		this.c_location = c_location;
	}

	@Column(name="ToAddress")
	private String to_add;
	  
	
	@Column(name="deliverydate")
	private String deliverydate;
	
	@Column(name="Distance")
	private String distance;
	
	
	@Column(name="dri_name")
	private String dri_name;
	
	@Column(name="dri_licence")
	private String dri_licence;
	
	 @Temporal(TemporalType.DATE)
	   
	    private Date date;
	 
	 @Column(name="salary")
		private String salary;
		
	

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getComlic() {
		return comlic;
	}

	public void setComlic(String comlic) {
		this.comlic = comlic;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getFrom_add() {
		return from_add;
	}

	public void setFrom_add(String from_add) {
		this.from_add = from_add;
	}

	public String getTo_add() {
		return to_add;
	}

	public void setTo_add(String to_add) {
		this.to_add = to_add;
	}

	
	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getDri_name() {
		return dri_name;
	}

	public void setDri_name(String dri_name) {
		this.dri_name = dri_name;
	}

	public String getDri_licence() {
		return dri_licence;
	}

	public void setDri_licence(String dri_licence) {
		this.dri_licence = dri_licence;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
public Booking(){
	
}
	
	public Booking(int id, String c_name, String comlic, String product, String c_location, String from_add, String to_add,
			String deliverydate, String distance, String dri_name, String dri_licence, Date date, String salary) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.comlic = comlic;
		this.product = product;
		this.from_add = from_add;
		this.to_add = to_add;
		this.deliverydate = deliverydate;
		this.distance = distance;
		this.dri_name = dri_name;
		this.dri_licence = dri_licence;
		this.date = date;
		this.salary = salary;
		this.c_location = c_location;
	}
	  
	
	
	

}
