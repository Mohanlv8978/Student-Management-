package com.example.Student.Management.Three.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Student.Management.Three.entity.Course;
import com.example.Student.Management.Three.entity.Student;
import com.example.Student.Management.Three.service.Courseservice;
import com.example.Student.Management.Three.service.StudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private Courseservice courseService;

	@GetMapping("/")
	public String view(Model model) {
		List<Student> listStudents = studentService.listAll();
		List<Course> listCourses = courseService.listAll();
		model.addAttribute("liststudent", listStudents);
		model.addAttribute("listcourse", listCourses);
		return "student";
	}

	@GetMapping("/addstudent")
	public String showAddStudentForm(Model model) {
		List<Student> listStudents = studentService.listAll();
		List<Course> listCourses = courseService.listAll();
		model.addAttribute("liststudent", listStudents);
		model.addAttribute("listcourse", listCourses);
		model.addAttribute("student", new Student());
		return "addstudent";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.save(student);
		return "redirect:/Student/";
	}

	@GetMapping("/edit/{id}")
	public String showEditStudentForm(@PathVariable("id") Long id, Model model) {
		Student student = studentService.get(id);
		List<Course> listCourses = courseService.listAll();
		model.addAttribute("student", student);
		model.addAttribute("listcourse", listCourses);
		return "addstudent";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.delete(id);
		return "redirect:/Student/";
	}
}
