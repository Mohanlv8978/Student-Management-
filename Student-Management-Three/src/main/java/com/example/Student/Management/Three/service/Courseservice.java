package com.example.Student.Management.Three.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Management.Three.entity.Course;
import com.example.Student.Management.Three.repository.CourseRepository;

@Service
public class Courseservice {
	@Autowired
    private CourseRepository repo;
	
	public List<Course> listAll() {
        return repo.findAll();
    }
     
    public void save(Course course) {
        repo.save(course);
    }
     
    public Course get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
