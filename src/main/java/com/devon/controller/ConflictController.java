package com.devon.controller;

import com.devon.model.Conflict;
import com.devon.model.component.Form;
import com.devon.model.component.Message;
import com.devon.repository.ComponentRepository;
import com.devon.repository.ConflictRepository;
import com.devon.repository.UserRepository;
import com.devon.service.ConflictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/conflict")
public class ConflictController {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ConflictRepository conflictRepository;

	@Autowired
	ConflictService conflictService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ComponentRepository componentRepository;


	@RequestMapping(method = RequestMethod.POST)
	public Conflict postConflict(@RequestBody Conflict conflict) {
		conflictRepository.save(conflict);
		return conflict;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Conflict getConflict(@PathVariable String id) {

		Conflict conflict = conflictRepository.findOne(id);
		conflict.setFirstUser(userRepository.findOne(conflict.getFirstUser().getId()));
		conflict.setSecondUser(userRepository.findOne(conflict.getSecondUser().getId()));
		conflict.setMediator(userRepository.findOne(conflict.getMediator().getId()));

		Message message1 = new Message();
		message1.setUserId(conflict.getFirstUser().getId());
		message1.setValue("I hate you");
		message1.setTimestamp(Calendar.getInstance().getTime());

		Message message2 = new Message();
		message2.setUserId(conflict.getSecondUser().getId());
		message2.setValue("I do too.");
		message2.setTimestamp(Calendar.getInstance().getTime());

		Message message3 = new Message();
		message3.setUserId(conflict.getMediator().getId());
		message3.setValue("Ok staph");
		message3.setTimestamp(Calendar.getInstance().getTime());

		conflict.addComponent(message1);
		conflict.addComponent(message2);
		conflict.addComponent(message3);
		return conflict;
	}

	@RequestMapping(method = RequestMethod.POST, value = "{conflictId}/message")
	public Message postConflictMessage(@RequestBody Message message, @PathVariable String conflictId) {
		conflictService.addConflictMessage(conflictId, message);
		return message;
	}

	@RequestMapping(method = RequestMethod.POST, value = "{conflictId}/form")
	public Form postConflictForm(@RequestBody Form form, @PathVariable String conflictId) {
		componentRepository.save(form);
		return form;
	}
}
