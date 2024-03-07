package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.mapper.CargoPropertiesSaveMapper;
import com.admazsshipping.entity.vo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    public ShippingEntity saveShipping(SaveShippingRequest shippingRequest) throws Exception {
        BigDecimal value;
        Double dimensionalWeight = null;

        switch (shippingRequest.getShippingSelectedType()) {
            case CUBED_CALCULATE -> {
                dimensionalWeight = calculationUseCase.calculateDimensionalWeight(
                        shippingRequest.getCargoPropertiesRequest().getLength(),
                        shippingRequest.getCargoPropertiesRequest().getWidth(),
                        shippingRequest.getCargoPropertiesRequest().getHeight(),
                        shippingRequest.getCargoPropertiesRequest().getCubageFactor()
                );

                value = calculationUseCase.calculateValueByDimensionalWeight(
                        shippingRequest.getCargoPropertiesRequest().getWeight(),
                        dimensionalWeight
                );
            }

            case WEIGHT_CALCULATE -> {
                value = calculationUseCase.calculateValueByWeight(
                        shippingRequest.getCargoPropertiesRequest().getWeight()
                );
            }

            default -> throw new Exception("ShippingType not defined");
        }


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
        BigDecimal value;
        Double dimensionalWeight = shippingEntity.getCargoProperties().getDimensionalWeight();

        switch (updateShippingRequest.getShippingSelectedType()) {
            case CUBED_CALCULATE -> {
                dimensionalWeight = calculationUseCase.calculateDimensionalWeight(
                        updateShippingRequest.getCargoPropertiesRequest().getLength(),
                        updateShippingRequest.getCargoPropertiesRequest().getWidth(),
                        updateShippingRequest.getCargoPropertiesRequest().getHeight(),
                        updateShippingRequest.getCargoPropertiesRequest().getCubageFactor()
                );

                value = calculationUseCase.calculateValueByDimensionalWeight(
                        updateShippingRequest.getCargoPropertiesRequest().getWeight(),
                        dimensionalWeight
                );
            }

            case WEIGHT_CALCULATE -> {
                value = calculationUseCase.calculateValueByWeight(
                        updateShippingRequest.getCargoPropertiesRequest().getWeight()
                );
            }

            default -> throw new Exception("ShippingType not defined");
        }

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

    public Page<ShippingEntity> findByAnyFields(String field, Pageable pageable) {
        return shippingDataProvider.findByAnyFields(field, pageable);
    }

    public ShippingEntity cancelShipping(String shippingId) throws Exception {
        ShippingEntity shippingEntity = shippingDataProvider.findById(shippingId);

        shippingEntity.setShippingStatus(ShippingStatusEnum.CANCELLED);

        return shippingDataProvider.updateShipping(shippingEntity);
    }

    public ResponseEntity<Void> deleteShipping(String shippingId) throws Exception {
        ShippingEntity shippingEntity = shippingDataProvider.findById(shippingId);
        return shippingDataProvider.deleteShipping(shippingEntity);
    }
}
