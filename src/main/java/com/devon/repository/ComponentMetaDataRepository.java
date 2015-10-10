package com.devon.repository;

import com.devon.model.ComponentMetaData;
import com.devon.model.Conflict;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComponentMetaDataRepository extends MongoRepository<ComponentMetaData, String> {


}
