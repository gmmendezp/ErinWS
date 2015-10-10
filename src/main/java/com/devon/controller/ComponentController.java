package com.devon.controller;

import com.devon.model.Conflict;
import com.devon.model.component.Message;
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
public class ComponentController {

	@Autowired
	ConflictRepository conflictRepository;

	@Autowired
	UserRepository userRepository;

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	public Conflict addConflict(
		@RequestParam(value = "firstUserId", required = true) String firstUserId,
		@RequestParam(value = "secondUserId", required = true) String secondUserId,
		@RequestParam(value = "mediatorId", required = true) String mediatorId
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
		@RequestParam(value = "id", required = true) String id) {

		Conflict conflict = conflictRepository.findOne(id);
		conflict.setFirstUser(userRepository.findOne(conflict.getFirstUser().getId()));
		conflict.setSecondUser(userRepository.findOne(conflict.getSecondUser().getId()));
		conflict.setMediator(userRepository.findOne(conflict.getMediator().getId()));

		Message message1 = new Message();
		message1.setUserId(conflict.getFirstUser().getId());
		message1.setValue("I hate you");

		Message message2 = new Message();
		message2.setUserId(conflict.getSecondUser().getId());
		message2.setValue("I do too.");

		Message message3 = new Message();
		message3.setUserId(conflict.getMediator().getId());
		message3.setValue("Ok staph");

		conflict.addComponent(message1);
		conflict.addComponent(message2);
		conflict.addComponent(message3);
		return conflict;
	}
}
