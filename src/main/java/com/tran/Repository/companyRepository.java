package com.tran.Repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tran.Model.*;
@Component
@Repository("companyRepository")
public interface companyRepository extends JpaRepository<Booking,Integer> {

	List<Booking> findByComlic(String comlic);


	

	
}
