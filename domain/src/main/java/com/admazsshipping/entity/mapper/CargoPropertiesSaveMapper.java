package com.admazsshipping.entity.mapper;

import com.admazsshipping.entity.vo.CargoPropertiesVO;
import com.admazsshipping.entity.vo.SaveCargoPropertiesRequest;
import com.admazsshipping.entity.vo.ShippingSelectedTypeEnum;

public enum CargoPropertiesSaveMapper {

    INSTANCE;

    public CargoPropertiesVO toCargoProperties(SaveCargoPropertiesRequest cargoPropertiesRequest, ShippingSelectedTypeEnum shippingSelectedType) {

        if (cargoPropertiesRequest == null) return null;

        Double dimensionalWeight = calculateDimensionalWeight(
                cargoPropertiesRequest.getLength(),
                cargoPropertiesRequest.getLength(),
                cargoPropertiesRequest.getHeight(),
                cargoPropertiesRequest.getCubageFactor());

        return new CargoPropertiesVO.CargoPropertiesVOBuilder()
                .weight(cargoPropertiesRequest.getWeight())
                .length(cargoPropertiesRequest.getLength())
                .width(cargoPropertiesRequest.getWidth())
                .height(cargoPropertiesRequest.getHeight())
                .cubageFactor(cargoPropertiesRequest.getCubageFactor())
                .dimensionalWeight(dimensionalWeight)
                .value(calculateShippingValue(cargoPropertiesRequest.getWeight(), dimensionalWeight, shippingSelectedType))
                .build();
    }

    private Double calculateDimensionalWeight(Double length, Double width, Double height, Double cubageFactor) {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * cubageFactor;
        return Math.round(dimensionalWeight * 100.0) / 100.0;
    }

    private Double calculateShippingValue(Double weight, Double dimensionalWeight, ShippingSelectedTypeEnum shippingSelectedType) {
        double cost = switch (shippingSelectedType) {
            case CUBED_CALCULATE -> Math.max(weight, dimensionalWeight) * 1;
            case WEIGHT_CALCULATE -> weight * 1;
        };
        return cost;
    }
}
