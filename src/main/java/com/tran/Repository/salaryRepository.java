package com.tran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tran.Model.salary;

@Component
@Repository("salaryRepository")
public interface salaryRepository extends JpaRepository<salary,Integer> {
	
	

}
