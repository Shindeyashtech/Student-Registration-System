    package com.example.StudentRegistration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.StudentRegistration.Domain.Student;
import com.example.StudentRegistration.Service.SService;
 

 

@Controller
public class SController {
	
	private final SService service;
	
	
	@Autowired
	public SController(SService service) {
		super();
		this.service = service;
	}
	@GetMapping("/")
	public String viewHomepage(Model model) {
		List<Student> liststudent = service.listAll();
		model.addAttribute("liststudent", liststudent);
		System.out.print("Get /");
		return "index";
		
	}
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "new";
	}
	@RequestMapping (value = "/save", method = RequestMethod.POST)
	public String saveStudent (@ModelAttribute("student")Student std)  {
		
		service.save(std);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name="id")int id) {
		ModelAndView mav = new ModelAndView("new");
		Student std = service.get(id);
		mav.addObject("student", std);
		return mav;
	}
	@RequestMapping("/edit/{id}")
	public String deleteStudent(@PathVariable(name="id")int id) {
		service.delete(id);
		return "redirect:/";
	}

	
}
