package com.project1.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.project1.dao.EmployeeRepository;
import com.project1.entities.Employee;

public class UniqueValidator implements ContraintValidator<UniqueValue, String>{
		
//	@Autowired
//	EmployeeRepository empRepo;
//	
//	@Override
//	public boolean isValid(String value, ConstraintValidatorContext context) {
//		
//		Employee emp = empRepo.findByEmail(emp);
//		
//		if(emp != null) 
//			return false;
//		 else 
//			return true;
//	}
	
	
	
	
	
	
	
	public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {
		
		@Autowired
		EmployeeRepository empRepo;
		
		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			
			Employee emp = empRepo.findByEmail(emp);
			
			if(emp != null) 
				return false;
			else 
				return true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
