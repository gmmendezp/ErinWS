package com.devon.model.component;

import java.util.Collection;

public class Answer extends Component {

	private Collection<String> answer;
	private String question;

	public Answer() {
		setType("ANSWER");
	}

	public Collection<String> getAnswer() {
		return answer;
	}

	public void setAnswer(Collection<String> answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
