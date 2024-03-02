package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingUseCase {

    private final ShippingDataProvider shippingDataProvider;

    public ShippingUseCase(ShippingDataProvider shippingDataProvider) {
        this.shippingDataProvider = shippingDataProvider;
    }

    public ShippingEntity saveShipping(ShippingEntity shipping){
        return shippingDataProvider.saveShipping(shipping);
    }

    public List<ShippingEntity> findAllShipping(){
        return shippingDataProvider.findAllShipping();
    }
}
