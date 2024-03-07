package com.admazsshipping.usecase;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculationUseCase {

    protected Double calculateDimensionalWeight(Double length, Double width, Double height, Double cubageFactor) {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * cubageFactor;
        return Math.round(dimensionalWeight * 100.0) / 100.0;
    }

    protected BigDecimal calculateValueByDimensionalWeight(Double weight, Double dimensionalWeight) {
        return BigDecimal.valueOf(Math.max(weight, dimensionalWeight) * 1);
    }

    protected BigDecimal calculateValueByWeight(Double weight){
        return new BigDecimal(weight * 1);
    }
}
