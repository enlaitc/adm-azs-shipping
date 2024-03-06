package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.mapper.CargoPropertiesSaveMapper;
import com.admazsshipping.entity.vo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ShippingUseCase {

    private final ShippingDataProvider shippingDataProvider;

    private final CalculationUseCase calculationUseCase;

    public ShippingUseCase(ShippingDataProvider shippingDataProvider, CalculationUseCase calculationUseCase) {
        this.shippingDataProvider = shippingDataProvider;
        this.calculationUseCase = calculationUseCase;
    }

    public ShippingEntity saveShipping(SaveShippingRequest shippingRequest) {
        Double dimensionalWeight = calculationUseCase.calculateDimensionalWeight(
                shippingRequest.getCargoPropertiesRequest().getLength(),
                shippingRequest.getCargoPropertiesRequest().getWidth(),
                shippingRequest.getCargoPropertiesRequest().getHeight(),
                shippingRequest.getCargoPropertiesRequest().getCubageFactor()
        );

        BigDecimal value = calculationUseCase.calculateShippingValue(
                shippingRequest.getCargoPropertiesRequest().getWeight(),
                dimensionalWeight,
                shippingRequest.getShippingSelectedType()
        );

        return shippingDataProvider.saveShipping(
                new ShippingEntity.ShippingEntityBuilder()
                        .id(null)
                        .recipientName(shippingRequest.getRecipientName())
                        .recipientAddress(shippingRequest.getRecipientAddress())
                        .shippingMethod(shippingRequest.getShippingMethod())
                        .shippingStatus(ShippingStatusEnum.POSTING)
                        .shippingSelectedType(shippingRequest.getShippingSelectedType())
                        .cargoProperties(CargoPropertiesSaveMapper.INSTANCE.toCargoProperties(shippingRequest.getCargoPropertiesRequest(), dimensionalWeight, value))
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

        Double dimensionalWeight = calculationUseCase.calculateDimensionalWeight(
                updateShippingRequest.getCargoPropertiesRequest().getLength(),
                updateShippingRequest.getCargoPropertiesRequest().getWidth(),
                updateShippingRequest.getCargoPropertiesRequest().getHeight(),
                updateShippingRequest.getCargoPropertiesRequest().getCubageFactor()
        );

        BigDecimal value = calculationUseCase.calculateShippingValue(
                updateShippingRequest.getCargoPropertiesRequest().getWeight(),
                dimensionalWeight,
                updateShippingRequest.getShippingSelectedType()
        );
        ShippingEntity updatedShippingEntity = new ShippingEntity.ShippingEntityBuilder()
                .id(shippingEntity.getId())
                .recipientName(updateShippingRequest.getRepicientName())
                .recipientAddress(updateShippingRequest.getRecipientAddress())
                .shippingMethod(updateShippingRequest.getShippingMethod())
                .shippingStatus(shippingEntity.getShippingStatus())
                .shippingSelectedType(updateShippingRequest.getShippingSelectedType())
                .cargoProperties(CargoPropertiesSaveMapper.INSTANCE.toCargoProperties(updateShippingRequest.getCargoPropertiesRequest(), dimensionalWeight, value))
                .trackingNumber(shippingEntity.getTrackingNumber())
                .shippingDate(shippingEntity.getShippingDate())
                .shippingUpdateDate(new Date(System.currentTimeMillis()))
                .expectedDeliveryDate(updateShippingRequest.getExpectedDeliveryDate())
                .build();

        return shippingDataProvider.updateShipping(updatedShippingEntity);
    }

    public Page<ShippingEntity> findByAnyFields(String field, Pageable pageable){
        return shippingDataProvider.findByAnyFields(field, pageable);
    }
}
