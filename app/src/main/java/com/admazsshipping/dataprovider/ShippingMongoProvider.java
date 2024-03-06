package com.admazsshipping.dataprovider;

import com.admazsshipping.dataprovider.model.Shipping;
import com.admazsshipping.dataprovider.repository.ShippingRepository;
import com.admazsshipping.entity.ShippingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    @Override
    public ShippingEntity updateShipping(ShippingEntity updatedShippingEntity) {
        return repository.save(new Shipping().toShipping(updatedShippingEntity)).toEntity();
    }

    @Override
    public ShippingEntity findById(String id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Shipping not found!"))
                .toEntity();
    }

    @Override
    public Page<ShippingEntity> findByAnyFields(String field, Pageable pageable) {
        return new PageImpl<>(repository.findByAnyFields(field, pageable).stream().map(Shipping::toEntity).toList());
    }
}
