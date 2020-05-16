package com.tran.Service;

import com.tran.Model.Driver;

public interface DriverService {
	//public Driver findByEmail(String email);
	// public Optional<User> findUserByResetToken(String resetToken);
	public void  saveDriver(Driver driver);
	Driver findUserByEmail(String email);


}


