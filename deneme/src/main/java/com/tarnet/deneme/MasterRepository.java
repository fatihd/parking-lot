package com.tarnet.deneme;

import com.tarnet.domain.ZzzMaster;

import java.util.List;

public interface MasterRepository {
    void insert();

    void update();

    void delete();

    void showOne();

    List<ZzzMaster> list();
}
