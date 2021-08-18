package com.tarnet.deneme;

import com.tarnet.domain.ZzzUsers;

import java.util.List;

public interface UsersRepository {
    void insert();

    /*void delete();*/

    List<ZzzUsers> list();

}
