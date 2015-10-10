package com.devon.controller;

import com.devon.model.User;
import com.devon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User getUser(@PathVariable String id) {
		return userRepository.findOne(id);
	}
}
