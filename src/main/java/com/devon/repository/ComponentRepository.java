package com.devon.repository;

import com.devon.model.component.Component;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComponentRepository extends MongoRepository<Component, String> {


}
