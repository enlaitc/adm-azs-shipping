package com.admazsshipping.dataprovider;


import com.admazsshipping.entity.ShippingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShippingDataProvider {

    ShippingEntity saveShipping(ShippingEntity shipping);
    List<ShippingEntity> findAllShipping();
    ShippingEntity updateShipping(ShippingEntity updatedShippingEntity);
    ShippingEntity findById(String id) throws Exception;
    Page<ShippingEntity> findByAnyFields(String field, Pageable pageable);
    ResponseEntity<Void> deleteShipping(ShippingEntity shippingEntity);
}
