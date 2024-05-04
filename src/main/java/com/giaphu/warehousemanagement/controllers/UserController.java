package com.giaphu.warehousemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giaphu.warehousemanagement.models.dtos.UserDTO;
import com.giaphu.warehousemanagement.models.entities.User;
import com.giaphu.warehousemanagement.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("")
	public ResponseEntity<?> getListUser() {
		List<UserDTO> users = userService.getUsersList();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		UserDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping("")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.createUser(user));
	}

}
