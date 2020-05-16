package com.tran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tran.Model.Driver;

@Repository("DriverRepository")
public interface DriverRepository extends JpaRepository<Driver,Long> {
	//Driver findByEmail(String email);

	Driver findByEmail(String email);
	
}
