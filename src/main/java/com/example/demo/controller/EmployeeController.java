package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping
	public List<Employee> getAllEmployees (){
		return repository.findAll();
	}
	
	@PostMapping
	public Employee createNewEmployee(@RequestBody Employee employee) {
		return this.repository.save(employee);
	}
	
}
