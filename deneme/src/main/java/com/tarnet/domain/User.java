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

    private int version;

    private String ad;

    private List<Spot> spot = new ArrayList<>();

    public void addSpot(Spot s){
        s.setUser(this);
        this.getSpot().add(s);
    }

}
