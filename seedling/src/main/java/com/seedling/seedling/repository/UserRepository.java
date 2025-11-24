package com.seedling.seedling.repository;

import com.seedling.seedling.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    List<UserEntity> findAllByNameContainingIgnoreCase(String userName);
}
