package com.tarnet.deneme;

import com.tarnet.domain.User;

import java.util.List;

public interface UserRepository {
    void insert();

    /*void delete();*/

    List<User> list();

}
