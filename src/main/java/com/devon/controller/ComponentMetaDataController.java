package com.devon.controller;

import com.devon.model.ComponentMetaData;
import com.devon.repository.ComponentMetaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/component/metadata")
public class ComponentMetaDataController {

	public final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ComponentMetaDataRepository componentMetaDataRepository;

	@RequestMapping(method = RequestMethod.POST)
	public ComponentMetaData postComponentMetadata(@RequestBody ComponentMetaData componentMetaData) {
		componentMetaDataRepository.save(componentMetaData);
		return componentMetaData;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ComponentMetaData putComponentMetadata(@RequestBody ComponentMetaData componentMetaData) {
		componentMetaDataRepository.save(componentMetaData);
		return componentMetaData;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ComponentMetaData getComponentMetadata(@PathVariable String id) {
		return componentMetaDataRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<ComponentMetaData> getAllComponentMetadata() {
		return componentMetaDataRepository.findAll();
	}
}
