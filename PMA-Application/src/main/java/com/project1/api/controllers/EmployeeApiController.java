package com.project1.api.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.project1.dao.EmployeeRepository;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
		
	@Autowired
	EmployeeRepository empRepo;
	
		//return list of employees
		@GetMapping
		public List<Employee> getEmployees() {
			return empRepo.findAll();
		}

	
	//get employee by id
	@GetMapping("{/id}")
	public Employee getEmployeeById(@PathVariable(id) Long id) {
		return empRepo.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
		return empRepo.save(employee);
	}
	
	@PatchMapping(path="{/id}", consumes="application/json")
	public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee patchEmployee) {
		
		Employee emp = empRepo.findById(id).get();
		
		if(patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		else if(patchEmployee.getFirstName() != null) {
			emp.setFirstName(patchEmployee.getFirstName());
		}
		else if(patchEmployee.getLastName() != null) {
			emp.setLastName(patchEmployee.getLastName());
		}
		return empRepo.save(emp);
	}
	
	@DeleteMapping("{/id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") long id) {
		try {
			empRepo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
//	@GetMapping(params= {"page", "size"})
//	@ResponseStatus(HttpStatus.OK)
//	public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, 
//			@RequestParam("size") int size) {
//		
//		Pageable pageAndSize = PageRequest.of(page, size);
//		
//		return empRepo.findAll(pageAndSize);
//	}
	
	
	@GetMapping(params= {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
		
		Pageable pageAndSize = PageRequest.of(page, size);
		
		return empRepo.findAll(pageAndSize);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}

  