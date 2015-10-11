package com.devon.controller;

import com.devon.model.User;
import com.devon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

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
}
