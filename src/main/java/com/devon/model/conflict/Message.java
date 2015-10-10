package com.devon.model.conflict;

import com.devon.model.User;

public class Message extends Component {

	private String value;

	private User user;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message() {
		this.setType("MESSAGE");
	}
}
