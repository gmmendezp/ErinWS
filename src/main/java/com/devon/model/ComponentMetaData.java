package com.devon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.data.annotation.Id;

import java.util.Map;

public class ComponentMetaData {

	@Id
	private String id;

	private Map metaData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map getMetaData() {
		return metaData;
	}

	public void setMetaData(Map metaData) {
		this.metaData = metaData;
	}

}
