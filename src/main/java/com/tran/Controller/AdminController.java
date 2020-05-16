package com.tran.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tran.Model.Booking;

import com.tran.Model.salary;
import com.tran.Repository.companyRepository;
import com.tran.Repository.salaryRepository;

@Controller
public class AdminController {

	@Autowired
	companyRepository jobrepo;
	
	@Autowired
	salaryRepository repository;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView view(ModelAndView model1,Model model) {
		
		 model.addAttribute("books", jobrepo.findAll());
		
		                                            
		 
		model1.setViewName("view");
		return model1;
		
	}
	
	@RequestMapping(value="/deletee/{id}",method=RequestMethod.GET)
	 public ModelAndView doDelete(@PathVariable("id") int id ,Model model) {
		ModelAndView model2=new ModelAndView();
		Booking book=jobrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		
			 	jobrepo.delete(book);
	      // model.addAttribute("bloods", repo.findAll());
	         model2.setViewName("adminhome");
	         return model2;
	 
	 }
	
	

	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	public ModelAndView viewall(ModelAndView model1,Model model) {
		 model.addAttribute("books", jobrepo.findAll());
		                    
		
		
		model1.setViewName("viewall");
		 
		 
		return model1;
		
	}
	
	@RequestMapping(value="/editing/{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable ("id")int id,Model model) {
		ModelAndView model1=new ModelAndView();
		Booking book=jobrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	
		model.addAttribute("book", book);
        model1.setViewName("salaryupdate");
        return model1;
	}
	
	@RequestMapping(value="/updating/{id}",method=RequestMethod.POST)
	public ModelAndView updated(@PathVariable("id") int id, @Valid salary Salary, BindingResult result,
	        Model model) {
		ModelAndView models=new ModelAndView();
		if(result.hasErrors()) {
			 Salary.setId(id);
			models.setViewName("salaryupdate");
		}
		else {
		repository.save(Salary);
		models.addObject("msg", "successful updated");
		models.setViewName("adminhome");
	}
    return models;

	

	}
	
	@RequestMapping(value="/viewsalary",method=RequestMethod.GET)
	public ModelAndView views(ModelAndView model1,Model model) {
		 model.addAttribute("salarys", repository.findAll());
		                    
		
		
		model1.setViewName("viewsalary");
		 
		 
		return model1;
		
	}
	@RequestMapping(value="/deletesalary/{id}",method=RequestMethod.GET)
	 public ModelAndView dodelete(@PathVariable("id") int id ,Model model) {
		ModelAndView model2=new ModelAndView();
		salary Salary=repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		
			 	repository.delete(Salary);
	      // model.addAttribute("bloods", repo.findAll());
	         model2.setViewName("adminhome");
	         return model2;
	 
	 }
	
}
