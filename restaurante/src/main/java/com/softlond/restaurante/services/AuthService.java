package com.softlond.restaurante.services;

import com.softlond.restaurante.models.UserEntity;
import com.softlond.restaurante.pojo.LoginRequest;
import com.softlond.restaurante.responses.Response;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<Response> login(LoginRequest loginRequest);
    Mono<Response> signup(UserEntity userEntity);
}
