package com.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.dao.EmployeeRepository;
import com.project1.dto.EmployeeProject;
import com.project1.entities.Employee;
import com.project1.entities.Project;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public Iterable<Employee> getAll() {
		return empRepo.findAll();
				
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}
	
	public Employee findByEmployeeId(long theId) {
		return empRepo.findByEmployeeId(theId);
	}
	
	public void delete(Employee theEmp) {
		empRepo.delete(theEmp);
	}
	
}
