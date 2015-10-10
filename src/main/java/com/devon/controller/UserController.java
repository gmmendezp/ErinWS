package com.devon.controller;

import com.devon.model.User;
import com.devon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public User addUser(
		@RequestParam(value = "id", required = true) java.lang.String id,
		@RequestParam(value = "name", required = true) java.lang.String name,
		@RequestParam(value = "type", required = true) java.lang.String type,
		@RequestParam(value = "thumbnail", required = true) java.lang.String thumbnail) {

		User user = new User();
		user.setName(name);
		user.setThumbnail(thumbnail);
		user.setType(type);
		user.setId(id);

		userRepository.save(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "id", required = true) java.lang.String id) {
		return userRepository.findOne(id);
	}
}
