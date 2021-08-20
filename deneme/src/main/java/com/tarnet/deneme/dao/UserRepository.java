package com.tarnet.deneme.dao;

import com.tarnet.deneme.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> list();

    User get(String id);
}
