package com.devon.controller;

import com.devon.model.component.Component;
import com.devon.repository.ComponentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/component")
public class ComponentController {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ComponentRepository componentRepository;

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Component getComponent(@PathVariable String id) {
		return componentRepository.findOne(id);
	}
}
