package com.tran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tran.Model.admin;

public interface adminRepository extends JpaRepository<admin,Long> {

	admin findByUsername(String username);
	
	

}
