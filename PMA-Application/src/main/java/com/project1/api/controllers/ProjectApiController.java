package com.project1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project1.dao.ProjectRepository;
import com.project1.entities.Employee;
import com.project1.entities.Project;

public class ProjectApiController {
		
	@RestController
	@RequestMapping("/app-api/projects")
	public class EmployeeApiController {
			
		@Autowired
		ProjectRepository proRepo;
		
		@GetMapping()
		public List<Project> getEmployees() {
			return proRepo.findAll();
		}
		
		@GetMapping("/{id}")
		public Project getProjectById(@PathVariable("id") Long Id) {
			return proRepo.findById(id).get();
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Project create(@RequestBody Project project) {
			return proRepo.save(project);
		}
		
		@PatchMapping(path="{/id}", consumes="application/json")
		public Project partialUpdate(@PathVariable("id") long id, @RequestBody Project patchProject) {
			Project pro = proRepo.findById(id).get();
			
			if(patchProject.getName() != null) {
				pro.setName(pro.getName());
			}
			if(patchProject.getDescription() != null) {
				pro.setDescription(patchProject.getDescription());
			}
			if(patchProject.getStage() != null) {
				pro.setStage(patchProject.getStage());
			}
			
			return proRepo.save(pro);
		}
		
		@DeleteMapping("{/id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable("id") Long id) {
			try {
				proRepo.deleteById(id);
			}
			catch(EmptyResultDataAccessException e) {
				
			}
		}	
	}
}
