package com.example.Student.Management.Three.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String coursename;
	private int duration;

	public Long getId() {
	return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

	public String getCoursename() {
	return coursename;
	}

	public void setCoursename(String coursename) {
	this.coursename = coursename;
	}

	public int getDuration() {
	return duration;
	}

	public void setDuration(int duration) {
	this.duration = duration;
	}

}
