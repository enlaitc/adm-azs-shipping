package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.CargoPropertiesVO;
import com.admazsshipping.entity.vo.SaveShippingRequest;
import com.admazsshipping.entity.vo.ShippingStatusEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                        .cargoProperties(new CargoPropertiesVO.CargoPropertiesVOBuilder()
                                .weight(shippingRequest.getCargoPropertiesRequest().getWeight())
                                .length(shippingRequest.getCargoPropertiesRequest().getLength())
                                .width(shippingRequest.getCargoPropertiesRequest().getWidth())
                                .height(shippingRequest.getCargoPropertiesRequest().getHeight())
                                .cubageFactor(shippingRequest.getCargoPropertiesRequest().getCubageFactor())
                                .dimensionalWeight(calculateDimensionalWeight(shippingRequest.getCargoPropertiesRequest().getLength(), shippingRequest.getCargoPropertiesRequest().getWidth(), shippingRequest.getCargoPropertiesRequest().getHeight()))
                                .build())
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

    private double calculateDimensionalWeight(Double length, Double width, Double height) {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * 300;
        return Math.round(dimensionalWeight * 100.0) / 100.0;
    }
}
