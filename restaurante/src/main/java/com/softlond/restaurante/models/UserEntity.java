package com.softlond.restaurante.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter @Setter @NoArgsConstructor
@Document(collection = "users")
public class UserEntity {
    @Id
    private String id;

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String name;
    @NotEmpty(message = "Last name may not be empty")
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters long")
    private String lastName;
    @NotEmpty(message = "Email may not be empty")
    private String email;
    @NotEmpty(message = "Password may not be empty")
    @Size(min = 8, max = 32, message = "Password must be between 8 and 32 characters")
    private String password;

    public UserEntity(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
