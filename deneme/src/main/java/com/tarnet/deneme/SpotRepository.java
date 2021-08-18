package com.tarnet.deneme;

import com.tarnet.domain.Spot;

import java.util.List;

public interface SpotRepository {
    List<Spot> list();

    Spot get(Long id);
}
