package com.devon.model.component;

public class Message extends Component {

	private String value;

	private String userId;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Message() {
		this.setType("MESSAGE");
	}
}
