package com.example.Student.Management.Three.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.Student.Management.Three.entity.Course;
import com.example.Student.Management.Three.service.Courseservice;

@Controller
@RequestMapping("/Course")
public class ClassController {

	@Autowired
	private Courseservice service;

	@GetMapping("/")
	public String view(Model model) {
		List<Course> listcourse = service.listAll();
		model.addAttribute("listcourse", listcourse);
		return "/course";

	}

	@GetMapping("/addcourse")
	public String add(Model model) {
		List<Course> listcourse = service.listAll();
		model.addAttribute("listcourse", listcourse);
		model.addAttribute("course", new Course());
		return "addcourse";
	}

	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course course) {
		service.save(course);
		return "redirect:/Course/";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("addcourse");
		Course course = service.get(id);
		mav.addObject("course", course);
		return mav;

	}

	@GetMapping("/delete/{id}")
	public String deleteCoursePage(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/Course/";
	}

}
