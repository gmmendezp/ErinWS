package com.devon.service;

import com.devon.model.component.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class ConflictService {

	@Autowired
	private MongoOperations mongoOperations;

	public void addConflictMessage(String conflictId, Message message){

//		mongoOperations.upsert()

	}
}
