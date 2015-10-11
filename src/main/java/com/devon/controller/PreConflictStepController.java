package com.devon.controller;

import com.devon.model.PreConflictStep;
import com.devon.repository.PreConflictStepRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/preConflictStep")
public class PreConflictStepController {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PreConflictStepRepository preConflictStepRepository;

	@RequestMapping(method = RequestMethod.POST)
	public PreConflictStep postPreConflictStep(@RequestBody PreConflictStep preConflictStep) {
		preConflictStepRepository.save(preConflictStep);
		return preConflictStep;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public PreConflictStep getPreConflictStep(@PathVariable String id) {
		return preConflictStepRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<PreConflictStep> getPreConflictStep() {
		return preConflictStepRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deletePreConflictStep(@PathVariable String id) {
		preConflictStepRepository.delete(id);
	}

}
