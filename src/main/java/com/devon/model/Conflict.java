package com.devon.model;

import org.springframework.data.annotation.Id;

public class Conflict {
	@Id
	private java.lang.String id;
	private User firstUser;
	private User secondUser;
	private User mediator;

	public User getMediator() {
		return mediator;
	}

	public void setMediator(User mediator) {
		this.mediator = mediator;
	}

	public User getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}

	public User getFirstUser() {
		return firstUser;
	}

	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}
}
