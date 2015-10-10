package com.devon.repository;

import com.devon.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, java.lang.String> {


}
