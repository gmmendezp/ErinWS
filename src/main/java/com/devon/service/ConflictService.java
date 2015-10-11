package com.devon.service;

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
}
