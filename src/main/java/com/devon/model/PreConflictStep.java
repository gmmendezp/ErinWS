package com.devon.model;

import org.springframework.data.annotation.Id;

public class PreConflictStep {

	@Id
	private String id;
	private String title;
	private String descriptor;
	private String helpLink;
	private boolean approved;

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getHelpLink() {
		return helpLink;
	}

	public void setHelpLink(String helpLink) {
		this.helpLink = helpLink;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
