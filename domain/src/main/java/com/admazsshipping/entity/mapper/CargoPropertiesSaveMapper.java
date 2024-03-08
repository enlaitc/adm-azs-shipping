package com.admazsshipping.entity.mapper;

import com.admazsshipping.entity.vo.CargoPropertiesVO;
import com.admazsshipping.entity.vo.SaveCargoPropertiesRequest;
import java.math.BigDecimal;

public enum CargoPropertiesSaveMapper {

    INSTANCE;

    public CargoPropertiesVO toCargoProperties(SaveCargoPropertiesRequest cargoPropertiesRequest, Double dimensionalWeight, BigDecimal value ) {

        if (cargoPropertiesRequest == null) return null;

        return new CargoPropertiesVO.CargoPropertiesVOBuilder()
                .weight(cargoPropertiesRequest.getWeight())
                .length(cargoPropertiesRequest.getLength())
                .width(cargoPropertiesRequest.getWidth())
                .height(cargoPropertiesRequest.getHeight())
                .cubageFactor(cargoPropertiesRequest.getCubageFactor())
                .dimensionalWeight(dimensionalWeight)
                .value(value)
                .build();
    }

}
