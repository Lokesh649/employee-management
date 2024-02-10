package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.NotFoundException;
import com.employee.repository.EmployeeRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EmployeeRepository userRepository;

	public List<Employee> getAllUsers() {
		return userRepository.findAll();
	}

	public Employee getUserById(Long id) {
		try {
			return userRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("User not found with id:-" + id));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee createUser(Employee user) {
		return userRepository.save(user);
	}

	public Employee updateUser(Long id, Employee userDetails) {
		Employee user = getUserById(id);
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
