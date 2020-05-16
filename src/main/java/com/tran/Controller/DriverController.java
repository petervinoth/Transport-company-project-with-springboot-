package com.tran.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import com.tran.Model.Driver;
import com.tran.Service.DriverService;
                                                                               
@Controller
public class DriverController {
	
	@Autowired
	DriverService service;
	
	BCryptPasswordEncoder Encoder=new BCryptPasswordEncoder(12);
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView create(ModelAndView model) {
		Driver driver=new Driver();
		model.addObject("driver", driver);
		model.setViewName("signup");
		return model;
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView add(@Valid Driver driver,BindingResult result) {
		ModelAndView model=new ModelAndView();
		Driver exit=service.findUserByEmail(driver.getEmail());
		 if(exit != null) {
			   result.rejectValue("email", "error.user", "This email already exists!");
			  }
		 if(result.hasErrors()) {
			 model.setViewName("signup");
		 }
		 else {
			 driver.setPassword(Encoder.encode(driver.getPassword()));
				
			 service.saveDriver(driver);
			   model.addObject("msg", "User has been registered successfully!");
			   model.addObject("driver", new Driver());
			   model.setViewName("signup");
			  }
			  
			  return model;
	}
	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	 public ModelAndView login() {
	  ModelAndView model = new ModelAndView();
	  System.out.println("/login end point is working!!!!");
	   
	  model.setViewName("login");
	 // model.addObject("message", "please correct email & Password!!");
	  // model.addObject("user", new User());
	 
	  return model;
	 }
	 @RequestMapping(value={"/home"}, method=RequestMethod.GET)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  Driver driver = service.findUserByEmail(auth.getName());
	  
	  model.addObject("userName", driver.getEmail());
	  model.addObject("id", driver.getLicno());

	  model.setViewName("home");
	  return model;
	 }
	 @RequestMapping(value="/driverlogout",method=RequestMethod.GET)
		public ModelAndView logiut(ModelAndView modelandview) {
			modelandview.setViewName("/");
			return modelandview;
		}
	 @RequestMapping(value="/about",method=RequestMethod.GET)
		public ModelAndView about(ModelAndView model) {
			model.setViewName("about");
			return model;
		}
	 
	 

}
