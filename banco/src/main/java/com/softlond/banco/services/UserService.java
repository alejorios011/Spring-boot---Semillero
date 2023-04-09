package com.softlond.banco.services;

import java.util.Map;

import com.softlond.banco.models.User;
import com.softlond.banco.responses.Response;

public interface UserService {
    public Map save(Object object);

    public void remove(Object object);

    public void update(String document, Object object);

    public Response showAll();

    public User findUserByDocument(String document);
}
