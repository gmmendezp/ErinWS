package com.devon.controller;

import com.devon.model.Conflict;
import com.devon.model.User;
import com.devon.repository.ConflictRepository;
import com.devon.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conflict")
public class ConflictController {

	@Autowired
	ConflictRepository conflictRepository;

	@Autowired
	UserRepository userRepository;

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	public Conflict addConflict(
		@RequestParam(value = "firstUserId", required = true) java.lang.String firstUserId,
		@RequestParam(value = "secondUserId", required = true) java.lang.String secondUserId,
		@RequestParam(value = "mediatorId", required = true) java.lang.String mediatorId
	) {

		//FAIL FAST
		if (!StringUtils.hasText(firstUserId)) {
			throw new IllegalArgumentException("First user needs to be a valid user id.");
		}

		if (!StringUtils.hasText(secondUserId)) {
			throw new IllegalArgumentException("Second user needs to be a valid user id.");
		}


		Conflict conflict = new Conflict();
		conflict.setFirstUser(userRepository.findOne(firstUserId));
		conflict.setSecondUser(userRepository.findOne(secondUserId));
		conflict.setMediator(userRepository.findOne(mediatorId));


		conflictRepository.save(conflict);
		return conflict;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Conflict getConflict(
		@RequestParam(value = "id", required = true) java.lang.String id) {

		Conflict conflict = conflictRepository.findOne(id);
		conflict.setFirstUser(userRepository.findOne(conflict.getFirstUser().getId()));
		conflict.setSecondUser(userRepository.findOne(conflict.getSecondUser().getId()));
		conflict.setMediator(userRepository.findOne(conflict.getMediator().getId()));

		return conflict;
	}
}
