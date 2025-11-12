package com.seedling.seedling.repository;

import com.seedling.seedling.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    // ...custom query methods...
}
