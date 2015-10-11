package com.devon.model.component;

import java.util.Map;

public class Form extends Component {

	private Map structure;

	public Form() {
		setType("FORM");
	}

	public Map getStructure() {
		return structure;
	}

	public void setStructure(Map structure) {
		this.structure = structure;
	}
}
