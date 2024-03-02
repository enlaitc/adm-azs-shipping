package com.admazsshipping.dataprovider;

import com.admazsshipping.dataprovider.model.Shipping;
import com.admazsshipping.dataprovider.repository.ShippingRepository;
import com.admazsshipping.entity.ShippingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShippingMongoProvider implements ShippingDataProvider{

    @Autowired
    private ShippingRepository repository;


    @Override
    public ShippingEntity saveShipping(ShippingEntity entity) {
        return repository.save(new Shipping().toShipping(entity)).toEntity();
    }

    @Override
    public List<ShippingEntity> findAllShipping() {
        return repository.findAll().stream().map(Shipping::toEntity).toList();
    }
}
