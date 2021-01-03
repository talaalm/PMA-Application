package com.project1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project1.dto.ChartData;
import com.project1.dto.TimeChartData;
import com.project1.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
		
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="select stage as label, Count(*) as value " + 
			"from project " + 
			"group by stage") 
			
	public List<ChartData> getProjectStatus();

	public Project findByEmployeeId(long theId);
	
	@Query(nativeQuery=true, value="select start_date as startDate, end_date as endDate, name as projectName from project")
	
	public List<TimeChartData> getTimeData();
	
	
	
}
