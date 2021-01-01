package com.example.csv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.csv.model.Employee;
import com.example.csv.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired 
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll() ;
	}

}
