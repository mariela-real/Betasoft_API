package com.ab.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.springboot.backend.model.Instructor;
import com.ab.springboot.backend.service.InstructorService;



@RestController
@RequestMapping("/api")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	@GetMapping("/instructor")
	public List<Instructor> getInstructores(){
		return instructorService.findAll();
		
	}
	

}