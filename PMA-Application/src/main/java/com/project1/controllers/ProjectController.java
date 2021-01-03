package com.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.entities.Employee;
import com.project1.entities.Project;
import com.project1.services.EmployeeService;
import com.project1.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired 
	EmployeeService empService;
		
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		Iterable<Employee> employees = empService.getAll();
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Errors errors, @Valid Project project,@RequestParam List<Long> employees, Model model) {
		
		if(errors.hasErrors())
			return "employees/new-project";
		
		//this should handle saving to the DB
		proService.save(project);
		//redirect 
		return "redirect:/projects"; 
	}
	
	
	@GetMapping("/timelines") 
	public String displayProjectTimelines(Model model) throws JsonProcessingException {4
		
		List<TimeChartData> timelineData = proService.getTimeData();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonTimelineString = objectMapper.writeValueAsString(timelineData);
		System.out.println("--------------------project timelines ------------------");
		System.out.println(jsonTimelineString);
		model.addAttribute("projectTimeList", jsonTimelineString);
		return "projects/project-timelines";
		}

	 
	
	@GetMapping("/timelines")
	public String diplayTimelines(@RequestParam("startDate" Date startDate, @RequestParam("startDate" Date startDate, Model model) {
		
	})
	
	@GetMapping("/update")
	public String displayProjectUpdateForm(@RequestParam("id") long theId, Model model) {
		Project theProj = proService.findByProjectId(theId);
		model.addAttribute("project", theProj);
		return "projects/new-project";
	}
	
	@GetMapping("delete")
	public String deleteProject(@RequestParam("id") long theId, Model model) {
		Project theProj = proService.findByProjectId(theId);
		proService.delete(theProj);
		return "redirect:/projects";
	}
	
	
}























