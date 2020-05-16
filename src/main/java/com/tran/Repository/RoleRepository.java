package com.tran.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tran.Model.Role;


@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role,Long> {
	
	Role findByRole(String role);

}
