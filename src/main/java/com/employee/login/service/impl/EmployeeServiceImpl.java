package com.employee.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.login.dao.EmployeeDao;
import com.employee.login.model.Employee;
import com.employee.login.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao dao;
	
	@Override
	public List<Employee> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Employee save(Employee emp) {
		return dao.save(emp);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

}
