package com.admazsshipping.dataprovider.model;

import org.springframework.data.annotation.Id;

public class Shipping {

    @Id
    private Long id;

    public Shipping() {
    }

    public Shipping(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
