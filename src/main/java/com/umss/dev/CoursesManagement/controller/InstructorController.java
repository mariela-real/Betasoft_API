package com.umss.dev.CoursesManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.umss.dev.CoursesManagement.model.Curso;
import com.umss.dev.CoursesManagement.model.Instructor;
import com.umss.dev.CoursesManagement.model.Views;
import com.umss.dev.CoursesManagement.service.CursoService;
import com.umss.dev.CoursesManagement.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorController {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private InstructorService instructorService;

	/**
	 * @JsonView(Views.instructorViews.class) @GetMapping("/instructor") public
	 *                                        List<Instructor> getInstructores(){
	 * 
	 *                                        return instructorService.findAll(); }
	 */
	@GetMapping("/instructor")
	@JsonView(Views.cursoViews.class)
	public List<Curso> getCursos(@RequestParam(required = false) String search) {
		if (search == null || search.isEmpty()) {
			return cursoService.findAll();
		} else {
			return cursoService.Search(search);
		}
	}

	@GetMapping("/instructor/{id}")
	@JsonView(Views.instructorViews.class)
	public Optional<Instructor> obtenerInstructor(@PathVariable Long id) {
		return instructorService.findById(id);
	}

}
