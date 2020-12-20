package com.employee.login.service;

import java.util.List;

import com.employee.login.model.Employee;

public interface  EmployeeService {
	Employee save(Employee user);

	List<Employee> findByName(String name);
	
	List<Employee> findAll();
}
