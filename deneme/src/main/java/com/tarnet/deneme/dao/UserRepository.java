package com.tarnet.deneme.dao;

import com.tarnet.deneme.domain.User;

import java.util.List;

public interface UserRepository {
    void insert();

    /*void delete();*/

    List<User> list();

    User get(String id);
}
