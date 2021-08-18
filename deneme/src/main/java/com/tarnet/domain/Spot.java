package com.tarnet.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@FieldNameConstants
@Getter @Setter
public class Spot {
    private Long id;

    private User users;

    private List<Reservation> reservations = new ArrayList<>();

    public void addReservations(Reservation r){
        r.setSpots(this);
        this.getReservations().add(r);
    }

}
