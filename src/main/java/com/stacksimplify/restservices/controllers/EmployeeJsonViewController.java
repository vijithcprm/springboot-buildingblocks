package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.entities.EmployeeViews;
import com.stacksimplify.restservices.repositories.EmployeeRepository;

@RestController
@RequestMapping(value = "/jsonview/employees")
@Validated
public class EmployeeJsonViewController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@JsonView(EmployeeViews.NormalView.class)
	@GetMapping("/normal/{id}")
	public Employee getEmployeeByIdForNormal(@PathVariable("id") @Min(1) Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		
		Employee employee = employeeOptional.get();
		
		return employee;
	}
	
	@JsonView(EmployeeViews.ManagerView.class)
	@GetMapping("/manager/{id}")
	public Employee getEmployeeByIdForMangager(@PathVariable("id") @Min(1) Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		
		Employee employee = employeeOptional.get();
		
		return employee;
	}
	
	@JsonView(EmployeeViews.HRView.class)
	@GetMapping("/hr/{id}")
	public Employee getEmployeeByIdForHR(@PathVariable("id") @Min(1) Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		
		Employee employee = employeeOptional.get();
		
		return employee;
	}

}
