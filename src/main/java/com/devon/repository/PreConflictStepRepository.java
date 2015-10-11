package com.devon.repository;

import com.devon.model.PreConflictStep;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PreConflictStepRepository extends MongoRepository<PreConflictStep, String> {


}
