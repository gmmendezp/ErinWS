package com.devon.service;

import com.devon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class UserService {

	private static final String COLLECTION_ID = "email";
	private static final String COLLECTION_NAME = "user";

	@Autowired
	private MongoOperations mongoOperations;

	public User loginUser(String email) {
		return mongoOperations.findOne(
			query(where(COLLECTION_ID).is(email)), User.class, (String) COLLECTION_NAME);

	}
}
