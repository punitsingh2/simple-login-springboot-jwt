package com.employee.login.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.login.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	
	Employee save(Employee user);

	List<Employee> findByName(String name);
	
	List<Employee> findAll();
}

