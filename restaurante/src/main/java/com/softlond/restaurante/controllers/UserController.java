package com.softlond.restaurante.controllers;

import com.softlond.restaurante.models.UserEntity;
import com.softlond.restaurante.responses.Response;
import com.softlond.restaurante.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public Flux<UserEntity> getUsers(){
        // Flux<Response> response = userService.showAll();

        // return response.map(resp -> {
        //     HttpHeaders headers = new HttpHeaders();
        //     headers.add("Content-Type", "application/json");

        //     return new ResponseEntity<Response>(resp, headers, HttpStatus.OK);
        // });
        return userService.showAll();
    }

    @GetMapping("/getUsersByEmail")
    public Mono<UserEntity> getUsersByEmail(@RequestParam String email){
        return userService.findUserByEmail(email);
    }

    @PostMapping("/postUser")
    public Mono<UserEntity> postUser(@RequestBody UserEntity user){
        return userService.save(user);
    }
}
