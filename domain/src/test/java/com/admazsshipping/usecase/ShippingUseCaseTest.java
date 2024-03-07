package com.admazsshipping.usecase;

import com.admazsshipping.dataprovider.ShippingDataProvider;
import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShippingUseCaseTest {

    @InjectMocks
    ShippingUseCase shippingUseCase;

    @Mock
    ShippingDataProvider shippingDataProvider;

    @Mock
    CalculationUseCase calculationUseCase;

    ShippingEntity shipping;

    @BeforeEach
    public void setUp() {
        shipping = new ShippingEntity.ShippingEntityBuilder()
                .cargoProperties(new CargoPropertiesVO(
                        1d,
                        1d,
                        1d,
                        1d,
                        1d,
                        1d,
                        BigDecimal.TEN

                ))
                .shippingStatus(ShippingStatusEnum.CANCELLED)
                .build();
    }

    @DisplayName("should save with success when passing WEIGHT_CALCULATE")
    @Test
    void saveShipping_ShouldReturnShippingWhenPassingWEIGHT_CALCULATEWithSaveSuccess() throws Exception {
        SaveShippingRequest shippingRequest = new SaveShippingRequest.SaveShippingRequestBuilder()
                .shippingSelectedType(ShippingSelectedTypeEnum.WEIGHT_CALCULATE)
                .cargoPropertiesRequest(
                        new SaveCargoPropertiesRequest.SaveCargoPropertiesRequestBuilder()
                                .weight(1D)
                                .width(1d)
                                .length(1d)
                                .height(1d)
                                .cubageFactor(1d)
                                .build()
                )
                .build();

        when(calculationUseCase.calculateValueByWeight(anyDouble()))
                .thenReturn(BigDecimal.ONE);
        when(shippingDataProvider.saveShipping(any(ShippingEntity.class)))
                .thenReturn(shipping);

        ShippingEntity savedShipping = shippingUseCase.saveShipping(shippingRequest);

        assertEquals(shipping, savedShipping);
        verify(shippingDataProvider).saveShipping(any(ShippingEntity.class));
        verify(calculationUseCase).calculateValueByWeight(shippingRequest.getCargoPropertiesRequest().getWeight());
        verifyNoMoreInteractions(shippingDataProvider);

    }

    @DisplayName("should save with success when passing CUBED_CALCULATE")
    @Test
    void saveShipping_ShouldReturnShippingWhenPassingCUBED_CALCULATEWithSaveSuccess() throws Exception {
        Double dimensionalWeight = 1d;
        BigDecimal value = BigDecimal.ONE;
        SaveShippingRequest shippingRequest = new SaveShippingRequest.SaveShippingRequestBuilder()
                .shippingSelectedType(ShippingSelectedTypeEnum.CUBED_CALCULATE)
                .cargoPropertiesRequest(
                        new SaveCargoPropertiesRequest.SaveCargoPropertiesRequestBuilder()
                                .weight(1D)
                                .width(1d)
                                .length(1d)
                                .height(1d)
                                .cubageFactor(1d)
                                .build()
                )
                .build();

        when(calculationUseCase.calculateDimensionalWeight(anyDouble(), anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(dimensionalWeight);
        when(calculationUseCase.calculateValueByDimensionalWeight(shippingRequest.getCargoPropertiesRequest().getWeight(), dimensionalWeight))
                .thenReturn(value);
        when(shippingDataProvider.saveShipping(any(ShippingEntity.class)))
                .thenReturn(shipping);

        ShippingEntity savedShipping = shippingUseCase.saveShipping(shippingRequest);

        assertEquals(shipping, savedShipping);
        verify(shippingDataProvider).saveShipping(any(ShippingEntity.class));
        verify(calculationUseCase).calculateDimensionalWeight(anyDouble(), anyDouble(), anyDouble(), anyDouble());
        verify(calculationUseCase).calculateValueByDimensionalWeight(anyDouble(), anyDouble());
        verifyNoMoreInteractions(shippingDataProvider);

    }

    @DisplayName("should update with success when passing WEIGHT_CALCULATE")
    @Test
    void updateShipping_ShouldReturnShippingWhenPassingWEIGHT_CALCULATEWithUpdateSuccess() throws Exception {
        UpdateShippingRequest shippingRequest =
                new UpdateShippingRequest.UpdateShippingRequestBuilder()
                        .shippingSelectedType(ShippingSelectedTypeEnum.WEIGHT_CALCULATE)
                        .cargoPropertiesRequest(
                                new SaveCargoPropertiesRequest.SaveCargoPropertiesRequestBuilder()
                                        .weight(1D)
                                        .width(1d)
                                        .length(1d)
                                        .height(1d)
                                        .cubageFactor(1d)
                                        .build()
                        )
                        .build();

        when(shippingDataProvider.findById(shippingRequest.getId()))
                .thenReturn(this.shipping);
        when(calculationUseCase.calculateValueByWeight(anyDouble()))
                .thenReturn(BigDecimal.ONE);
        when(shippingDataProvider.updateShipping(any(ShippingEntity.class)))
                .thenReturn(this.shipping);

        ShippingEntity updatedShipping = shippingUseCase.updateShipping(shippingRequest);

        assertEquals(this.shipping, updatedShipping);
        verify(shippingDataProvider).updateShipping(any(ShippingEntity.class));
        verify(calculationUseCase).calculateValueByWeight(shippingRequest.getCargoPropertiesRequest().getWeight());
        verifyNoMoreInteractions(shippingDataProvider);
    }

    @DisplayName("should update with success when passing CUBED_CALCULATE")
    @Test
    void updateShipping_ShouldReturnShippingWhenPassingCUBED_CALCULATEWithUpdateSuccess() throws Exception {
        Double dimensionalWeight = 1d;
        BigDecimal value = BigDecimal.ONE;
        UpdateShippingRequest shippingRequest =
                new UpdateShippingRequest.UpdateShippingRequestBuilder()
                        .shippingSelectedType(ShippingSelectedTypeEnum.CUBED_CALCULATE)
                        .cargoPropertiesRequest(
                                new SaveCargoPropertiesRequest.SaveCargoPropertiesRequestBuilder()
                                        .weight(1D)
                                        .width(1d)
                                        .length(1d)
                                        .height(1d)
                                        .cubageFactor(1d)
                                        .build()
                        )
                        .build();

        when(shippingDataProvider.findById(shippingRequest.getId()))
                .thenReturn(this.shipping);
        when(calculationUseCase.calculateDimensionalWeight(anyDouble(),anyDouble(),anyDouble(),anyDouble()))
                .thenReturn(dimensionalWeight);
        when(calculationUseCase.calculateValueByDimensionalWeight(shippingRequest.getCargoPropertiesRequest().getWeight(), dimensionalWeight))
                .thenReturn(value);
        when(shippingDataProvider.updateShipping(any(ShippingEntity.class)))
                .thenReturn(this.shipping);

        ShippingEntity updatedShipping = shippingUseCase.updateShipping(shippingRequest);

        assertEquals(this.shipping, updatedShipping);
        verify(shippingDataProvider).updateShipping(any(ShippingEntity.class));
        verify(calculationUseCase).calculateDimensionalWeight(anyDouble(),anyDouble(),anyDouble(),anyDouble());
        verify(calculationUseCase).calculateValueByDimensionalWeight(anyDouble(),anyDouble());
        verifyNoMoreInteractions(shippingDataProvider);
    }


    @DisplayName("should return list of all shipping when success")
    @Test
    void findAllShipping_ShouldReturnAllShippingWithSuccess() {
        when(shippingDataProvider.findAllShipping()).thenReturn(Collections.singletonList(shipping));

        List<ShippingEntity> shippingEntityList = shippingUseCase.findAllShipping();

        assertEquals(Collections.singletonList(shipping), shippingEntityList);
        verify(shippingDataProvider).findAllShipping();
        verifyNoMoreInteractions(shippingDataProvider);
    }

    @DisplayName("should return a pageable shipping list find by any field when success")
    @Test
    void findByAnyFields_ShouldReturnPageOfShippingEntityWithSuccess() {
        when(shippingDataProvider.findByAnyFields(anyString(), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(this.shipping)));

        Page<ShippingEntity> shippingEntityPage = shippingUseCase.findByAnyFields("", Pageable.unpaged());

        assertEquals(new PageImpl<>(List.of(shipping)), shippingEntityPage);
        verify(shippingDataProvider).findByAnyFields(anyString(), any(Pageable.class));
        verifyNoMoreInteractions(shippingDataProvider);
    }

    @DisplayName("Should return NoContent when delete a ship with success ")
    @Test
    void deleteShipping_ShouldReturnNoContentWhenDeleteShippingWithSuccess() throws Exception {
        String shippingId = "";
        when(shippingDataProvider.findById(shippingId))
                .thenReturn(this.shipping);
        when(shippingDataProvider.deleteShipping(any(ShippingEntity.class)))
                .thenReturn(ResponseEntity.noContent().build());

        ResponseEntity<Void> response = shippingUseCase.deleteShipping(shippingId);

        assertEquals(ResponseEntity.noContent().build(), response);
        verify(shippingDataProvider).deleteShipping(any(ShippingEntity.class));
        verifyNoMoreInteractions(shippingDataProvider);
    }

    @DisplayName("Should return Shipping when update with Status CANCELLED with success")
    @Test
    void cancelShipping_ShouldReturnShippingEntityWhenUpdateWithSuccess() throws Exception {
        String shippingId = "";
        ShippingEntity shippingEntity = new ShippingEntity.ShippingEntityBuilder()
                .shippingStatus(ShippingStatusEnum.POSTING)
                .build();

        when(shippingDataProvider.findById(shippingId))
                .thenReturn(this.shipping);
        when(shippingDataProvider.updateShipping(any(ShippingEntity.class)))
                .thenReturn(this.shipping);

        ShippingEntity response = shippingUseCase.cancelShipping(shippingId);

        assertEquals(ShippingStatusEnum.CANCELLED, response.getShippingStatus());
        verify(shippingDataProvider).updateShipping(any(ShippingEntity.class));
        verifyNoMoreInteractions(shippingDataProvider);
    }
}