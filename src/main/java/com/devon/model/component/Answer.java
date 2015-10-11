package com.devon.model.component;

import java.util.Map;

public class Answer extends Component {

	private Map answer;
	private String question;

	public Answer() {
		setType("ANSWER");
	}

	public Map getAnswer() {
		return answer;
	}

	public void setAnswer(Map answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
