package com.seedling.seedling.repository;

import com.seedling.seedling.entity.LikeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends MongoRepository<LikeEntity, String> {
    // ...custom query methods...
}
