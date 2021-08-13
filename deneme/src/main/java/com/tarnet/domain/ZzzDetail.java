package com.tarnet.domain;

public class ZzzDetail {
    private Long id;

    private int numara;

    private ZzzMaster master;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public ZzzMaster getMaster() {
        return master;
    }

    public void setMaster(ZzzMaster master) {
        this.master = master;
    }
}
