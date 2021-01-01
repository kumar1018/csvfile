package com.example.csv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.csv.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	
	List<Employee> findAll();
	

}
