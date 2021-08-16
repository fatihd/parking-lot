package com.tarnet.domain;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@FieldNameConstants
@Data
public class ZzzSpots {
    private Long id;

    private ZzzUsers users;

    private List<ZzzReservations> reservations = new ArrayList<>();

    public void addReservations(ZzzReservations r){
        r.setSpots(this);
        this.getReservations().add(r);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZzzUsers getUsers() {
        return users;
    }

    public void setUsers(ZzzUsers users) {
        this.users = users;
    }
}
