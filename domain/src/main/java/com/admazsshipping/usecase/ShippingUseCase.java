package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.mapper.CargoPropertiesSaveMapper;
import com.admazsshipping.entity.vo.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShippingUseCase {

    private final ShippingDataProvider shippingDataProvider;

    public ShippingUseCase(ShippingDataProvider shippingDataProvider) {
        this.shippingDataProvider = shippingDataProvider;
    }

    public ShippingEntity saveShipping(SaveShippingRequest shippingRequest) {
        return shippingDataProvider.saveShipping(
                new ShippingEntity.ShippingEntityBuilder()
                        .id(null)
                        .recipientName(shippingRequest.getRecipientName())
                        .recipientAddress(shippingRequest.getRecipientAddress())
                        .shippingMethod(shippingRequest.getShippingMethod())
                        .shippingStatus(ShippingStatusEnum.POSTING)
                        .shippingSelectedType(shippingRequest.getShippingSelectedType())
                        .cargoProperties(CargoPropertiesSaveMapper.INSTANCE.toCargoProperties(shippingRequest.getCargoPropertiesRequest(), shippingRequest.getShippingSelectedType()))
                        .trackingNumber(shippingRequest.getTrackingNumber())
                        .shippingDate(new Date(System.currentTimeMillis()))
                        .shippingUpdateDate(null)
                        .expectedDeliveryDate(shippingRequest.getExpectedDeliveryDate())
                        .build()
        );
    }

    public List<ShippingEntity> findAllShipping() {
        return shippingDataProvider.findAllShipping();
    }

    public ShippingEntity updateShipping(UpdateShippingRequest updateShippingRequest) throws Exception {

        ShippingEntity shippingEntity = shippingDataProvider.findById(updateShippingRequest.getId());
        ShippingEntity updatedShippingEntity = new ShippingEntity.ShippingEntityBuilder()
                .id(shippingEntity.getId())
                .recipientName(updateShippingRequest.getRepicientName())
                .recipientAddress(updateShippingRequest.getRecipientAddress())
                .shippingMethod(updateShippingRequest.getShippingMethod())
                .shippingStatus(shippingEntity.getShippingStatus())
                .shippingSelectedType(updateShippingRequest.getShippingSelectedType())
                .cargoProperties(CargoPropertiesSaveMapper.INSTANCE.toCargoProperties(updateShippingRequest.getCargoPropertiesRequest(), updateShippingRequest.getShippingSelectedType()))
                .trackingNumber(shippingEntity.getTrackingNumber())
                .shippingDate(shippingEntity.getShippingDate())
                .shippingUpdateDate(new Date(System.currentTimeMillis()))
                .expectedDeliveryDate(updateShippingRequest.getExpectedDeliveryDate())
                .build();

        return shippingDataProvider.updateShipping(updatedShippingEntity);
    }
}
