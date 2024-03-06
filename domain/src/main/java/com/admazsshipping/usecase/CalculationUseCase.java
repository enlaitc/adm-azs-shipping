package com.admazsshipping.usecase;

import com.admazsshipping.entity.vo.ShippingSelectedTypeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculationUseCase {

    protected Double calculateDimensionalWeight(Double length, Double width, Double height, Double cubageFactor) {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * cubageFactor;
        return Math.round(dimensionalWeight * 100.0) / 100.0;
    }

    protected BigDecimal calculateShippingValue(Double weight, Double dimensionalWeight, ShippingSelectedTypeEnum shippingSelectedType) {
        double cost = switch (shippingSelectedType) {
            case CUBED_CALCULATE -> Math.max(weight, dimensionalWeight) * 1;
            case WEIGHT_CALCULATE -> weight * 1;
        };
        return new BigDecimal(cost);
    }
}
