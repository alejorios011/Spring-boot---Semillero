package com.softlond.banco.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.softlond.banco.models.User;

public interface UserRepository extends MongoRepository<User, String>{
    @Query("{document: '?0'}")
    User findUserByDocument(String document);

    @Query(value="{lastName:'?0'}", fields="{'name' : 1, 'lastName' : 1, 'document' : 1}")
    List<User> findAll(String lastName);
}
