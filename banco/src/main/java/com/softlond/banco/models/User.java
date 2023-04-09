package com.softlond.banco.models;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String name;
    @NotEmpty(message = "Last Name may not be empty")
    @Size(min = 2, max = 32, message = "Last Name must be between 2 and 32 characters long")
    private String lastName;
    @NotEmpty(message = "Document may not be empty")
    @Size(min = 2, max = 11, message = "Document must be between 2 and 11 characters long")
    @Indexed(unique = true)
    private String document;
    private Date created_at;

    // Constructor
    public User(String name, String lastName, String document) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.created_at = new Date();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
