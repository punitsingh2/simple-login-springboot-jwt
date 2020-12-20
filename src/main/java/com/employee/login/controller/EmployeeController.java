package com.employee.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.login.model.Employee;
import com.employee.login.service.EmployeeService;

@RestController
@RequestMapping(value= "api/employee", produces = "application/json")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public Employee registerUser(@RequestBody Employee emp) {
		return empService.save(emp);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> retrunAvailableEmplyees() {
		return empService.findAll();
	}
	
	@RequestMapping(value = "/{empname}", method = RequestMethod.GET)
	public List<Employee> searchEmployee(@PathVariable String empname) {
		return empService.findByName(empname);
	}

	

}
