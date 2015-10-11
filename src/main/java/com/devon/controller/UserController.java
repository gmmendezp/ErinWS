package com.devon.controller;

import com.devon.model.User;
import com.devon.repository.UserRepository;
import com.devon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public User postUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User getUser(@PathVariable String id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> getUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteUser(@PathVariable String id) {
		userRepository.delete(id);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "login")
	public ResponseEntity<User> loginUser(@RequestParam(value = "email", required = true) String email) {
		User user = userService.loginUser(email);

		if (email != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
}
