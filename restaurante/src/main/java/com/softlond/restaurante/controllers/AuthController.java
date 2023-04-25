package com.softlond.restaurante.controllers;

import com.softlond.restaurante.pojo.LoginRequest;
import com.softlond.restaurante.responses.Response;
import com.softlond.restaurante.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Mono<ResponseEntity<Response>> login(@RequestBody LoginRequest loginRequest){
        Mono<Response> login = authService.login(loginRequest);

        return login.map(loginResponse -> {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return new ResponseEntity<Response>(loginResponse, headers, HttpStatus.OK);
        });
    }
}
