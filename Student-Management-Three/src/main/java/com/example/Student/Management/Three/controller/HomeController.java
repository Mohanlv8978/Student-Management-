package com.example.Student.Management.Three.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping("/")
	    public String viewHomePage() {
	        return "index";
	    }
}
