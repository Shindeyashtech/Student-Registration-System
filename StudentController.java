package com.example.Student.Controller;

import java.util.List;
import com.example.Student.Domain.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
imp   ort org.springframework.web.servlet.ModelAndView;
import org.springframework.*;
import com.exmaple.Student.Service.StudentService;

public class StudentController {
	private StudentService service
;
	@GetMapping("/")
	public String viewHomepage(Model model) {
		List<Student> liststudent = service.listAll();
		model.addAttribute("liststudent", liststudent);
		System.out.print("Get /");
		return "index";
		
	}
	@GetMapping("/ new")
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
