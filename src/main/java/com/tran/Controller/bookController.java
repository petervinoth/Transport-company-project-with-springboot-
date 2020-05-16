package com.tran.Controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;



import com.tran.Repository.companyRepository;
import com.tran.Repository.companyproRepository;
import com.tran.Model.Booking;
import com.tran.Model.companypro;

@Controller
public class bookController {
	
	@Autowired
	companyRepository repo;
	
	@Autowired
	 companyproRepository  repository;
	
	
	
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public ModelAndView Book(ModelAndView model) {
		model.setViewName("Booking");
		return model;
		
	}
	
	@RequestMapping(value="/booking",method=RequestMethod.POST)
	public ModelAndView bookpost(@Valid Booking book,BindingResult result) {
		ModelAndView model=new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName("Booking");
		}
		else {
			repo.save(book);
			model.addObject("msg", "successful Booking..");
			model.setViewName("Booking");
		}
		return model;
	}
	@RequestMapping(value="/probook",method=RequestMethod.GET)
	public ModelAndView profile(ModelAndView model) {
		model.setViewName("probook");
		return model;
		
	}
	@RequestMapping(value="/probook",method=RequestMethod.POST)
	public ModelAndView propost(@Valid companypro pro,BindingResult result) {
		ModelAndView model=new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName("probook");
		}
		else {
			repository.save(pro);
			model.addObject("msg", "successful Booking..");
			model.setViewName("probook");
		}
		return model;
	}
	
	
	@RequestMapping(value="/select/{comlic}",method=RequestMethod.GET)
	public ModelAndView search(@RequestParam(name="comlic", required=false)String comlic,Model model) {
		ModelAndView model1=new ModelAndView();
		List<Booking> books=repo.findByComlic(comlic);
		model.addAttribute("books", repo.findByComlic(comlic));
		model1.setViewName("searchbook");
		return model1;
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	 public ModelAndView showUpdateForm(@PathVariable("id") int id, Model model) {
		ModelAndView model1=new ModelAndView();
        Booking book = repo.findById(id) .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        		 
        model.addAttribute("book", book);
        model1.setViewName("updatebooking");
        return model1;
 }
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ModelAndView updated(@PathVariable("id") int id, @Valid Booking book, BindingResult result,
	        Model model) {
		ModelAndView models=new ModelAndView();
		if(result.hasErrors()) {
			 book.setId(id);
			models.setViewName("updatebooking");
		}
		else {
		repo.save(book);
		models.addObject("msg", "successful updated");
		models.setViewName("Booking");
	}
    return models;
}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	 public ModelAndView doDelete(@PathVariable("id") int id ,Model model) {
		ModelAndView model2=new ModelAndView();
		Booking book=repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		
				 	repo.delete(book);
	      //  model.addAttribute("bloods", repo.findAll());
	         model2.setViewName("Booking");
	         return model2;
	 
	 }
	
}
