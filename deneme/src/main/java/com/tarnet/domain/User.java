package com.tarnet.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@FieldNameConstants
@Getter @Setter
public class User {
    private Long id;

    private String ad;

    private int version;

    private List<Spot> spots = new ArrayList<>();

    public void addSpots(Spot s){
        s.setUsers(this);
        this.getSpots().add(s);
    }

}
