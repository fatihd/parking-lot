package com.tarnet.domain;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@FieldNameConstants
@Data
public class ZzzUsers {
    private Long id;

    private String ad;

    private int version;

    private List<ZzzSpots> spots = new ArrayList<>();

    public void addSpots(ZzzSpots s){
        s.setUsers(this);
        this.getSpots().add(s);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
