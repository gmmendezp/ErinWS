package com.devon.model;

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
