package com.tran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tran.Model.companypro;

@Component
@Repository
public interface companyproRepository extends JpaRepository<companypro,Integer> {

}
