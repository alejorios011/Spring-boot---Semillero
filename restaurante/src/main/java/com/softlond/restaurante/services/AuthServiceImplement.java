package com.softlond.restaurante.services;

import com.softlond.restaurante.models.UserEntity;
import com.softlond.restaurante.pojo.LoginRequest;
import com.softlond.restaurante.pojo.LoginResponse;
import com.softlond.restaurante.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImplement implements AuthService{
    @Autowired
    private UserService userService;

    @Override
    public Mono<Response> login(LoginRequest loginRequest) {
        Mono<UserEntity> userFound = userService.findUserByEmail(loginRequest.getUser());

        return userFound.map(user -> {
            if (user.getPassword().equals(loginRequest.getPassword())){
                LoginResponse loginResponse = new LoginResponse("token", user.getEmail());

                return new Response("¡Successful Process!", loginResponse);
            }

            return new Response("Incorrect Credentials", null);
        });
    }

    @Override
    public Mono<Response> signup(UserEntity userEntity) {
        return null;
    }
}
