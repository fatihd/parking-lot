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

    private User user;

    private List<Reservation> reservation = new ArrayList<>();

    public void addReservation(Reservation r){
        r.setSpot(this);
        this.getReservation().add(r);
    }

}
