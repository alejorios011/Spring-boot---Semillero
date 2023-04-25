package com.softlond.restaurante.services;

import com.softlond.restaurante.models.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    public Mono<UserEntity> save(UserEntity user);

    public void remove(Object object);

    public void update(String document, Object object);

    public Flux<UserEntity> showAll();

    public Mono<UserEntity> findUserByEmail(String email);
}
