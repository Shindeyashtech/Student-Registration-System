  package com.example.StudentRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentRegistration.Domain.Student;
@Repository
      public interface SRepository extends JpaRepository<Student, Integer> {

	 
}
