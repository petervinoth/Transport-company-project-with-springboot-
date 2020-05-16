package com.tran.Service;




import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tran.Model.Role;

import com.tran.Model.Driver;
import com.tran.Repository.DriverRepository;
import com.tran.Repository.RoleRepository;

@Component
@Service("DriverService")
public class DriverServiceImpl implements DriverService  {
	
	@Autowired
	DriverRepository driverrepository;
	
	@Autowired
	RoleRepository rolerepository;
	
	
	
	 
	 @Override
	 public void saveDriver(Driver user) {
		 // user.setPassword(PasswordEncoder.encode(user.getPassword()));
		  user.setActive(1);
		  Role userRole = rolerepository.findByRole("ADMIN");
		  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  driverrepository.save(user);
		 }

	@Override
	public Driver findUserByEmail(String email) {
		// TODO Auto-generated method stub
		 return driverrepository.findByEmail(email);

		
	}
	 
	

}
