package com.tarnet.deneme.dao;

import com.tarnet.deneme.domain.Spot;

import java.util.List;

public interface SpotRepository {
    List<Spot> list();

    Spot get(Long id);
}
