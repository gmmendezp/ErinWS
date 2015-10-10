package com.devon.model;

import com.devon.model.conflict.Component;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Collection;

public class Conflict {
	@Id
	private java.lang.String id;
	private User firstUser;
	private User secondUser;
	private User mediator;
	private Collection<Component> components = new ArrayList<Component>();

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

	public Collection<Component> getComponents() {
		return components;
	}

	public void setComponents(Collection<Component> components) {
		this.components = components;
	}

	public boolean removeComponent(Object o) {
		return getComponents().remove(o);
	}

	public boolean addComponent(Component component) {
		return getComponents().add(component);
	}
}
