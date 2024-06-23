package com.example.Student.Management.Three.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Student.Management.Three.entity.Student;
	
	@Repository
	public interface StudentRepository extends JpaRepository<Student, Long> {
	    @Query(value="select s.id, s.studentname, c.coursename from student s Inner JOIN course c ON s.course=c.id", nativeQuery=true)
	    List<Student> findStudent();
	}

	



	

