package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.SaveShippingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingUseCase {

    private final ShippingDataProvider shippingDataProvider;

    public ShippingUseCase(ShippingDataProvider shippingDataProvider) {
        this.shippingDataProvider = shippingDataProvider;
    }

    public ShippingEntity saveShipping(SaveShippingRequest shippingRequest) {
        return shippingDataProvider.saveShipping(
                new ShippingEntity.ShippingBuilder()
                        .id(null)
                        .recipientName(shippingRequest.getRecipientName())
                        .recipientAddress(shippingRequest.getRecipientAddress())
                        .shippingMethod(shippingRequest.getShippingMethod())
                        .trackingNumber(shippingRequest.getTrackingNumber())
                        .shippingDate(shippingRequest.getShippingDate())
                        .expectedDeliveryDate(shippingRequest.getExpectedDeliveryDate())
                        .isDelivered(false)
                        .weight(shippingRequest.getWeight())
                        .length(shippingRequest.getLength())
                        .width(shippingRequest.getWidth())
                        .height(shippingRequest.getHeight())
                        .dimensionalWeight(calculateDimensionalWeight(shippingRequest.getLength(),shippingRequest.getWidth(),shippingRequest.getHeight()))
                        .build()
        );
    }

    public List<ShippingEntity> findAllShipping() {
        return shippingDataProvider.findAllShipping();
    }

    public double calculateDimensionalWeight(Double length, Double width, Double height) {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * 300;
        return Math.round(dimensionalWeight * 100.0) / 100.0;
    }
}
