package com.project1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.EmployeeRepository;
import com.project1.dao.ProjectRepository;
import com.project1.dto.ChartData;
import com.project1.dto.EmployeeProject;
import com.project1.entities.Project;

@Controller
@PropertySource({"classpath:application-test.properties"})
public class HomeController {
		
	@Value("${version}")
	private String ver;

	@Autowired
	ProjectRepository proRepo; 
	
	@Autowired
	EmployeeRepository empRepo;
		
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		Map<String, Object> map = new HashMap<>();
		
		//we are querying the DB for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proRepo.getProjectStatus();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//[ ["NOTSTARTED, 1], ["INPROGRESS", 2], ["COMPLETED", 1] ]
		
		model.addAttribute("projectStatusCnt", jsonString);
	
		//we are querying the DB for employees
		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		
		return "main/home";
	}
	
}
