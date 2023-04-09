package com.softlond.banco.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.softlond.banco.models.User;
import com.softlond.banco.repository.UserRepository;
import com.softlond.banco.responses.Response;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map save(Object object) {
        User newUser = (User) object;

        Map<String, String> objectResponse = new HashMap<>();

        User userSave = userRepository.save(newUser);

        if(userSave == null){
            objectResponse.put("message", "Failed to save user");
        } else {
            objectResponse.put("message", "User saved succesfully");
        }

        return objectResponse;
    }

    @Override
    public void remove(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void update(String document, Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Response showAll() {
        String message;
        List<User> usersFound = userRepository.findAll();

        if(usersFound == null){
            message = "Failed to find users";
            usersFound = new ArrayList<>();
        } else if(usersFound.isEmpty()){
            message = "No users found";
            usersFound = new ArrayList<>();
        } else {
            message = "Success! found users";
        }
        return new Response(message, usersFound);
    }

    @Override
    public User findUserByDocument(String document){
        return  userRepository.findUserByDocument(document);
    }
}
