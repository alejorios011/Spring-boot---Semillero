package com.softlond.restaurante.repository;

import com.softlond.restaurante.models.UserEntity;

import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository <UserEntity, String> {
    @Query("{email: '?0'}")
    Mono <UserEntity> findUserByEmail(String email);
}
