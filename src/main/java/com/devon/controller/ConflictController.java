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

import java.util.Collection;

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

		return conflict;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Conflict> getConflict() {
		return conflictRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteConflict(@PathVariable String id) {
		conflictRepository.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "{conflictId}/message")
	public Message postConflictMessage(@RequestBody Message message, @PathVariable String conflictId) {
		conflictService.addConflictMessage(conflictId, message);
		return message;
	}

	@RequestMapping(method = RequestMethod.POST, value = "{conflictId}/form")
	public Form postConflictForm(@RequestBody Form form, @PathVariable String conflictId) {
		conflictService.addConflictForm(conflictId, form);
		return form;
	}

//	RequestMapping(method = RequestMethod.GET, value = "{id}")
//	public Component getComponent(@PathVariable String id) {
//		return componentRepository.findOne(id);
//	}
}
