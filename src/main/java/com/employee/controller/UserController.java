package com.employee.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getall")
	public List<Employee> getAllUsers() {
		List<Employee> allUsers = userService.getAllUsers();
		 Collections.sort(allUsers, Comparator.comparingLong(Employee::getId).reversed());
		return allUsers;
	}

	@GetMapping("/get/{id}")
	public Employee getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/create")
	public Employee createUser(@RequestBody Employee user) {
		return userService.createUser(user);
	}

	@PutMapping("/update/{id}")
	public Employee updateUser(@PathVariable Long id, @RequestBody Employee userDetails) {
		return userService.updateUser(id, userDetails);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
}
