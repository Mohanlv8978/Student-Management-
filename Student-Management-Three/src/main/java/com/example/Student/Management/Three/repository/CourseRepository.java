package com.example.Student.Management.Three.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.Management.Three.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>  {

}
