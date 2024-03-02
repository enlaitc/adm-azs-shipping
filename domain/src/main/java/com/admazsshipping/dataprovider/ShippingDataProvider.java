package com.admazsshipping.dataprovider;


import com.admazsshipping.entity.ShippingEntity;

import java.util.List;

public interface ShippingDataProvider {

    ShippingEntity saveShipping(ShippingEntity shipping);

    List<ShippingEntity> findAllShipping();
}
