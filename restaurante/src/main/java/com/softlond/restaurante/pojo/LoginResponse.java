package com.softlond.restaurante.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginResponse {
    private String token;
    private String user;

    public LoginResponse(String token, String user) {
        this.token = token;
        this.user = user;
    }
}
