package com.tarnet.web;

import com.tarnet.deneme.domain.Spot;
import com.tarnet.deneme.domain.User;

import java.util.ArrayList;
import java.util.List;

public class SpotDtoFactory {

    public static SpotDto createFromSpot(Spot spot) {
        SpotDto spotDto = new SpotDto();
        spotDto.setId(spot.getId());
        spotDto.setCode(spot.getCode());
        return spotDto;
    }

    static List<SpotDto> createFromSpotList(List<Spot> list) {
        List<SpotDto> sonuc = new ArrayList<>();

        for (Spot s : list)
            sonuc.add(createFromSpot(s));
        return sonuc;
    }

}
