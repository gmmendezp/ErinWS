package com.devon.model;

import org.springframework.data.annotation.Id;

public class ComponentMetaData {

	@Id
	private String id;

	private String metaData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public ComponentMetaData() {

	}

	public ComponentMetaData(String id, String metaData) {
		this.id = id;
		this.metaData = metaData;
	}
}
