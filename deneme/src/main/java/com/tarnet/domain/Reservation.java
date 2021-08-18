package com.tarnet.domain;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
@Data
public class ZzzReservations {
    private Long id;

    private ZzzSpots spots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZzzSpots getSpots() {
        return spots;
    }

    public void setSpots(ZzzSpots spots) {
        this.spots = spots;
    }
}
