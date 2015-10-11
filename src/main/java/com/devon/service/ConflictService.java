package com.devon.service;

import com.devon.model.PreConflictStep;
import com.devon.model.component.Answer;
import com.devon.model.component.Call;
import com.devon.model.component.Form;
import com.devon.model.component.Message;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class ConflictService {

	private static final String COLLECTION_ID = "_id";
	private static final String COLLECTION_NAME = "conflict";
	private static final String COMPONENT_PROP_NAME = "components";
	private static final String PRE_CONFLICT_STEP_PROP_NAME = "preConflictSteps";

	@Autowired
	private MongoOperations mongoOperations;

	public void addConflictMessage(String conflictId, Message message) {

		if (message.getId() == null) {
			message.setId(ObjectId.get().toString());
		}

		if (message.getTimestamp() == null) {
			message.setTimestamp(Calendar.getInstance().getTime());
		}

		mongoOperations.updateFirst(
			query(where(COLLECTION_ID).is(conflictId)),
			new Update().push(COMPONENT_PROP_NAME, message), (String) COLLECTION_NAME);

	}

	public void addConflictForm(String conflictId, Form form) {

		if (form.getId() == null) {
			form.setId(ObjectId.get().toString());
		}

		if (form.getTimestamp() == null) {
			form.setTimestamp(Calendar.getInstance().getTime());
		}

		mongoOperations.updateFirst(
			query(where(COLLECTION_ID).is(conflictId)),
			new Update().push(COMPONENT_PROP_NAME, form), (String) COLLECTION_NAME);

	}

	public void addConflictAnswer(String conflictId, Answer answer) {

		if (answer.getId() == null) {
			answer.setId(ObjectId.get().toString());
		}

		if (answer.getTimestamp() == null) {
			answer.setTimestamp(Calendar.getInstance().getTime());
		}

		mongoOperations.updateFirst(
			query(where(COLLECTION_ID).is(conflictId)),
			new Update().push(COMPONENT_PROP_NAME, answer), (String) COLLECTION_NAME);

	}

	public void addConflictPreConflictStep(String conflictId, PreConflictStep preConflictStep) {

		if (preConflictStep.getId() == null) {
			preConflictStep.setId(ObjectId.get().toString());
		}

		mongoOperations.updateFirst(
			query(where(COLLECTION_ID).is(conflictId)),
			new Update().push(PRE_CONFLICT_STEP_PROP_NAME, preConflictStep), (String) COLLECTION_NAME);

	}

	public void addConflictCall(String conflictId, Call call) {

		if (call.getId() == null) {
			call.setId(ObjectId.get().toString());
		}


		if (call.getTimestamp() == null) {
			call.setTimestamp(Calendar.getInstance().getTime());
		}

		mongoOperations.updateFirst(
			query(where(COLLECTION_ID).is(conflictId)),
			new Update().push(COMPONENT_PROP_NAME, call), (String) COLLECTION_NAME);

	}
}
