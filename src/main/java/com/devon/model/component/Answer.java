package com.devon.model.component;

import java.util.ArrayList;
import java.util.Collection;

public class Answer extends Component {

	private ArrayList<String> answer;
	private String question;

	public Answer() {
		setType("ANSWER");
	}

	public ArrayList<String> getAnswer() {
		return answer;
	}

	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
