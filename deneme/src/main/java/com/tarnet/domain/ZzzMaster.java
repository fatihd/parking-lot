package com.tarnet.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@FieldNameConstants
@Data
public class ZzzMaster {
    private Long id;
    private int version;

    private String ad;

    private List<ZzzDetail> detaylar = new ArrayList<>();

    public void detayEkle(ZzzDetail d) {
        d.setMaster(this);
        this.getDetaylar().add(d);
    }
}
