package com.devon.model.component;

public class Message extends Component {

	private String value;

	public Message() {
		this.setType("MESSAGE");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
