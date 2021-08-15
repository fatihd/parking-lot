package com.tarnet.deneme;

import com.tarnet.domain.ZzzUsers;

import java.util.List;

public interface UserRepository {
    void insert();

    List<ZzzUsers> list();

}
