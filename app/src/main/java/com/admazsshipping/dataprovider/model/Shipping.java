package com.admazsshipping.dataprovider.model;

import com.admazsshipping.entity.ShippingEntity;
import org.springframework.data.annotation.Id;

public class Shipping {

    @Id
    private Long id;

    public Shipping() {
    }

    public Shipping(Long id) {
        this.id = id;
    }

    public ShippingEntity toEntity() {
        return new ShippingEntity(
                this.getId()
        );
    }

    public Shipping toShipping(ShippingEntity entity) {
        return new Shipping(
                entity.getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
