package com.devon.controller;

import com.devon.model.ComponentMetaData;
import com.devon.model.Conflict;
import com.devon.model.component.Message;
import com.devon.repository.ComponentMetaDataRepository;
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

import java.util.Collection;

@RestController
@RequestMapping("/component/metadata")
public class ComponentMetaDataController {

	@Autowired
	ComponentMetaDataRepository componentMetaDataRepository;


	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	public ComponentMetaData addComponentMetadata(
		@RequestParam(value = "id", required = true) String id,
		@RequestParam(value = "metadata", required = true) String metadata
	) {

		//FAIL FAST
		if (!StringUtils.hasText(id)) {
			throw new IllegalArgumentException("Component id needs to be a valid id.");
		}

		if (!StringUtils.hasText(metadata)) {
			throw new IllegalArgumentException("Component meta data needs to contant data.");
		}

		ComponentMetaData componentMetaData = new ComponentMetaData(id, metadata);
		componentMetaDataRepository.save(componentMetaData);
		return componentMetaData;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ComponentMetaData getComponentMetadata(
		@RequestParam(value = "id") String id) {
		return componentMetaDataRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public Collection<ComponentMetaData> getAllComponentMetadata() {
		return componentMetaDataRepository.findAll();
	}
}
