package com.softlond.restaurante.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginRequest {
    private String user;
    private String password;

    public LoginRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
