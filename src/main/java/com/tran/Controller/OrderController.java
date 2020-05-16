package com.tran.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.tran.Model.Booking;
import com.tran.Repository.companyRepository;


import java.util.*;

import javax.validation.Valid;
@Controller
public class OrderController {
	
	@Autowired
	companyRepository repo;
	
	
	@RequestMapping(value="/vieworder",method=RequestMethod.GET)
	public ModelAndView view(ModelAndView model1,Model model) {
		 model.addAttribute("books", repo.findAll());
		                                            
		 
		model1.setViewName("vieworder");
		return model1;
		
	}
	
	
	@RequestMapping(value="/take",method=RequestMethod.GET)
	public ModelAndView job(ModelAndView model2, Model model) {
		 model.addAttribute("books", repo.findAll());
         
		 
			model2.setViewName("takejob");
			return model2;
			
	}
	@RequestMapping(value="/change/{id}",method=RequestMethod.GET)
	 public ModelAndView showUpdateForm(@PathVariable("id") int id, Model model) {
		ModelAndView model1=new ModelAndView();
       Booking book = repo.findById(id) .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

       		 
       model.addAttribute("book", book);
       model1.setViewName("takejob1");
       return model1;
}
	
	@RequestMapping(value="/new/{id}",method=RequestMethod.POST)
	public ModelAndView updated(@PathVariable("id") int id, @Valid  Booking book, BindingResult result,
	        Model model) {
		ModelAndView models=new ModelAndView();
		if(result.hasErrors()) {
			 book.setId(id);
			models.setViewName("takejob1");
		}
		else {
		repo.save(book);
		//models.addObject("msg", "successful updated");
		models.setViewName("welcome");
	}
   return models;
}
	
}
