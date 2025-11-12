package com.seedling.seedling.repository;

import com.seedling.seedling.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<ProjectEntity, String> {
    // ...add custom query methods if needed...
}
