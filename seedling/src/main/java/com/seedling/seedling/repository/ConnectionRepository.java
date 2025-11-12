package com.seedling.seedling.repository;

import com.seedling.seedling.entity.ConnectionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends MongoRepository<ConnectionEntity, String> {
    // ...custom query methods...
}
