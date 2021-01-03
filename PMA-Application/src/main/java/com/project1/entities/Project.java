package com.project1.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
		
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	@SequenceGenerator(allocationSize=1, name = "project_generator")
	
	
	private long projectId;
	
	
	@NotBlank(message=" * Must give a name")
	@Size(min=2, max=30)
	private String name;
	
	
	@NotBlank(message=" * Must give a stage")
	@Size(min=2, max=15)
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS
	
	
	@NotBlank(message=" * Must give a message")
	@Size(min=2, max=500)
	private String desc ription;
	
	
	@NotBlank(message=" * Date cannot be empty")
	private Date startDate;
	
	
	@NotBlank(message=" * Date cannot be empty")
	private Date endDate;
	
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns=@JoinColumn(name="project_id"),
				inverseJoinColumns=@JoinColumn(name="employee_id")
	)
	
	@JsonIgnore
	private List<Employee> employees;
		
	public Project() {
		
	}
	
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	
	
	
	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//convenience method
	public void addEmployee(Employee emp) {
	if(employees == null) {
		employees = new ArrayList<>();
	}
	employees.add(emp);
}
	
	
}
