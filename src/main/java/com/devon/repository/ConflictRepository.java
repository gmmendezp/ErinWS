package com.devon.repository;

import com.devon.model.Conflict;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConflictRepository extends MongoRepository<Conflict, String> {


}
