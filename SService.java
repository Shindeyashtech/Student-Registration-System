package com.example.StudentRegistration.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudentRegistration.Domain.Student;
import com.example.StudentRegistration.Repository.SRepository;
 
 
@Service
public class SService {


	private SRepository repo;
	
	@Autowired
	public SService(SRepository repo) {
		super();
		this.repo = repo;
	}

	
	public List <Student> listAll(){
		return repo.findAll();
	}
	
	public void save (Student std ) {
		repo.save(std);
	}
//	public void edit (Student std ) {
//		repo.edit(std);
//	}
	
	public void delete( int id ) {
		repo.deleteById(id);
	}
	
	public Student get (int id ) {
		return repo.findById(id).get();
	}
	 

}
