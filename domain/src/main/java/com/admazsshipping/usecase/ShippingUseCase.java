package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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
                        .cargoProperties(CargoPropertiesSaveMapper.INSTANCE.toCargoProperties(shippingRequest.getCargoPropertiesRequest()))
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

        ShippingEntity shippingEntity = shippingDataProvider.findById(updateShippingRequest.id);

        ShippingEntity updatedShippingEntity = new ShippingEntity.ShippingEntityBuilder()
                .recipientName(updateShippingRequest.repicientName)
                .recipientAddress(updateShippingRequest.recipientAddress)
                .shippingMethod(updateShippingRequest.shippingMethod)
                .shippingSelectedType(updateShippingRequest.shippingSelectedType)
                .cargoProperties(CargoPropertiesSaveMapper.INSTANCE.toCargoProperties(updateShippingRequest.cargoPropertiesRequest))
                .shippingUpdateDate(new Date(System.currentTimeMillis()))
                .expectedDeliveryDate(updateShippingRequest.expectedDeliveryDate)
                .build();

        for (Field field : ShippingEntity.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(updatedShippingEntity) != null && !field.get(updatedShippingEntity).equals(field.get(shippingEntity))) {

                if (field.get(shippingEntity) == shippingEntity.getRecipientAddress()) {

                    for (Field field1 : field.get(shippingEntity).getClass().getDeclaredFields()) {
                        field1.setAccessible(true);
                        if (field1.get(updatedShippingEntity.getRecipientAddress()) != null && !field1.get(updatedShippingEntity.getRecipientAddress()).equals(field1.get(shippingEntity.getRecipientAddress()))) {
                            field1.set(shippingEntity.getRecipientAddress(), field1.get(updatedShippingEntity.getRecipientAddress()));
                        }
                    }
                    continue;
                }

                field.set(shippingEntity, field.get(updatedShippingEntity));
            }
        }

        return shippingDataProvider.updateShipping(shippingEntity);
    }
}
