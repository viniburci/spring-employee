package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping
	public List<Employee> getAllEmployees (){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable Long id) {
		Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No employee with id: " + id));
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping
	public Employee createNewEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee (@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No employee with id: " + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		Employee updatedEmployee = repository.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
}
