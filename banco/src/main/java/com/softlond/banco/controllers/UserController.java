package com.softlond.banco.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.softlond.banco.models.User;
import com.softlond.banco.responses.Response;
import com.softlond.banco.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/showUsers")
    public ResponseEntity<Response> getUsers(){
        Response response = userService.showAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<Response>(response, headers, HttpStatus.OK);
    }

    @GetMapping("/findUser")
    public ResponseEntity<User> getUserByDocument(@RequestParam String document){
        User userFound = userService.findUserByDocument(document);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return  new ResponseEntity<User>(userFound, headers, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Map> postUsers(@RequestBody User user){
        Map responseSaved = userService.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        return new ResponseEntity<Map>(responseSaved, headers, HttpStatus.OK);
    }
}
