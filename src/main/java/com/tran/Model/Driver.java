package com.tran.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tran.Model.Role;

@Entity
@Table(name = "Driver")
public class Driver {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 
 private int id;
 
 @Column(name = "Name")
 private String Name;
 
 @Column(name="email")
 private String email;
 
 @Column(name="address")
 private String address;
 
 @Column(name="licenceNo")
 private String licno;
 
 @Column(name="phoneNo")
 private String ph_no;
 
 @Column(name="password")
 private String password;
 
 @Column(name = "active")
 private int active;
 
 @ManyToMany(cascade=CascadeType.ALL)
 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
 private Set<Role> roles;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getLicno() {
	return licno;
}

public void setLicno(String licno) {
	this.licno = licno;
}

public String getPh_no() {
	return ph_no;
}

public void setPh_no(String ph_no) {
	this.ph_no = ph_no;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getActive() {
	return active;
}

public void setActive(int active) {
	this.active = active;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

 
 
}