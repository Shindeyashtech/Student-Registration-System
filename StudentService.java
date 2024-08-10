package com.exmaple.Student.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
   import com.example.Student.Repository.*;
import com.example.Student.Controller.*;
import com.example.Student.Domain.*;
@Service

public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List <Student> listAll(){
		return repo.findAll()
	}
	
	public void save (Student std ) {
		repo.save(std);
	}
	
	public void delete(long id ) {
		repo.deleteByID(id);
	}
	
	public Student get (long id ) {
		return repo.findByID(id).get();
	}
	 

}
