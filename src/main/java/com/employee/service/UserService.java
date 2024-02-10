package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

@Service
public interface UserService {
	
	public List<Employee> getAllUsers();

	public Employee getUserById(Long id);

	public Employee createUser(Employee user);

	public Employee updateUser(Long id, Employee userDetails);

	public void deleteUser(Long id);
}
