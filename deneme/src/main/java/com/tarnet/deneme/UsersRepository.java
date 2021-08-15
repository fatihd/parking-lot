package com.tarnet.deneme;

import com.tarnet.domain.ZzzUsers;

import java.util.List;

public interface UsersRepository {
    void insert();

    List<ZzzUsers> list();

}
