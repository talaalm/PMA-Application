package com.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project1.dao.ProjectRepository;
import com.project1.dto.ChartData;
import com.project1.dto.TimeChartData;
import com.project1.entities.Project;

public class ProjectService {
	
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}

	public Project findByProjectId(long theId) {
		return proRepo.findByEmployeeId(theId);
	}

	public void delete(Project theProj) {
		proRepo.delete(theProj);
	}
	
	public List<TimeChartData> getTimeData() {
		return proRepo.getTimeData();
	}
}
