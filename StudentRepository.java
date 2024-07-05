package com.example.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.Domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

	void deleteByID(long id);

	Object findByID(long id);

}
