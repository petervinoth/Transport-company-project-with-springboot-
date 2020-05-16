package com.tran.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.tran.Model.admin;
import com.tran.Repository.adminRepository;
@Controller
public class loginController {
	
	@Autowired
	adminRepository repository;
	
	BCryptPasswordEncoder Encoder=new BCryptPasswordEncoder(12);
	
	
	@RequestMapping(value="/adsignup",method=RequestMethod.GET)
		public ModelAndView adsign(ModelAndView model,admin Admin) {
			model.addObject("admin", Admin);
		model.setViewName("adminsignup");
		return model;
	}
	
	@RequestMapping(value="/adsignup",method=RequestMethod.POST)
	public ModelAndView postadmin(admin Admin) {
		ModelAndView model=new ModelAndView();
		admin existingUser=repository.findByUsername(Admin.getUsername());
		if(existingUser!=null) {
			model.addObject("message","this email already register");
			model.setViewName("error");
		}
		else {
		Admin.setPassword(Encoder.encode(Admin.getPassword()));
		repository.save(Admin);
		model.addObject("message","sucessful register");
		model.setViewName("adminsignup");
	}
	return model;
}
	@RequestMapping(value= "/adlogin",method=RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView modelandview,admin Admin) {
		modelandview.addObject("admin",Admin);
		modelandview.setViewName("adminlogin");
		return modelandview;
	}
	
	@RequestMapping(value= "/adlogin",method=RequestMethod.POST)
	public ModelAndView loginpage(ModelAndView modelandview,admin Admin) {
		admin existingUser=repository.findByUsername(Admin.getUsername());
		if(existingUser!=null) {
			if(Encoder.matches(Admin.getPassword(), existingUser.getPassword())) {
				modelandview.addObject("message","welcome");
				modelandview.setViewName("adminhome");
			}
			else {
				modelandview.addObject("message","incorrect password");
				modelandview.setViewName("adminlogin");
			}
		}
			else {
				modelandview.addObject("message","not exist");
				modelandview.setViewName("adminlogin");
			}
		return modelandview;
	}
	@RequestMapping(value="/adminhome", method=RequestMethod.GET)
	 public ModelAndView home(ModelAndView modelandview) {
		 modelandview.setViewName("adminhome");
		 return modelandview;
	 }
	@RequestMapping(value="/Logout",method=RequestMethod.GET)
	public ModelAndView logiut(ModelAndView modelandview) {
		modelandview.setViewName("adminlogin");
		return modelandview;
	}
	
}
