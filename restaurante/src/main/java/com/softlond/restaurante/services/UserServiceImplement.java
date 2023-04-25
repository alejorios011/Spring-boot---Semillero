package com.softlond.restaurante.services;

import com.softlond.restaurante.models.UserEntity;
import com.softlond.restaurante.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImplement implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserEntity> save(UserEntity user) {
        return userRepository.save(user);
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
    public Flux<UserEntity> showAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<UserEntity> findUserByEmail(String email) {
        Mono<UserEntity> userFound = userRepository.findUserByEmail(email);

        return userFound.map(user -> {
            return user;
        });
    }

}
