package com.tran.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salary")
public class salary {


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="drivername")
	private String dri_name;
	
	@Column(name="driverId")
	private String dri_licence;
	
	@Column(name="Companyname")
	private String c_name;
	
	@Column(name="product")
	private String product;
	
	
	@Column(name="distance")
	private String distance;
	
	
	@Column(name="salary")
	private String salary;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) {
		this.distance = distance;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	
	
	
	
}
