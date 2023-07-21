package com.backend.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.auth.model.User;
import com.backend.auth.service.UserService;

@RestController
@RequestMapping("/api/v1.0/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAllUsers")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<?> getAllUsers(){
		List<User> userList=userService.getAllUsers();
		if(userList!=null) {
			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		}
		return new ResponseEntity<String>("UserList is empty",HttpStatus.NO_CONTENT);
	}
	

}
