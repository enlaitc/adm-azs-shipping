package com.admazsshipping.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculationUseCaseTest {

    @InjectMocks
    CalculationUseCase calculationUseCase;

    @Test
    void calculateDimensionalWeight_ShouldReturnCorrectDoubleWithSuccess() {
        Double length = 80D;
        Double width = 60D;
        Double height = 40D;
        Double cubageFactor = 300D;

        Double response = calculationUseCase.calculateDimensionalWeight(length,width,height,cubageFactor);

        assertEquals(57.6D, response);
        assertEquals(Double.class, response.getClass());
    }

    @Test
    void calculateValueByDimensionalWeight_ShouldReturnCorrectBigDecimalWithSuccess() {
        Double weight = 1D;
        Double dimensionalWeight = 1D;

        BigDecimal response = calculationUseCase.calculateValueByDimensionalWeight(weight,dimensionalWeight);

        assertEquals(BigDecimal.valueOf(1.0), response);
        assertEquals(BigDecimal.class, response.getClass());
    }

    @Test
    void calculateValueByWeight_calculateValueByDimensionalWeight_ShouldReturnCorrectBigDecimalWithSuccess() {
        Double weight = 1d;
        BigDecimal response = calculationUseCase.calculateValueByWeight(weight);

        assertEquals(BigDecimal.ONE, response);
        assertEquals(BigDecimal.class, response.getClass());
    }
}