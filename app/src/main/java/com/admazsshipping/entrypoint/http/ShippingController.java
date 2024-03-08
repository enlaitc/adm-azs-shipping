package com.admazsshipping.entrypoint.http;

import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.SaveShippingRequest;
import com.admazsshipping.entity.vo.ShippingStatusEnum;
import com.admazsshipping.entity.vo.UpdateShippingRequest;
import com.admazsshipping.usecase.ShippingUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/shippings")
public class ShippingController {


    @Autowired
    private ShippingUseCase shippingUseCase;

    @Operation(summary = "Save shipping")
    @PostMapping
    public ShippingEntity saveShipping(@Valid @RequestBody SaveShippingRequest shippingRequest) throws Exception {
        return shippingUseCase.saveShipping(shippingRequest);
    }

    @Operation(summary = "Find all shippings")
    @GetMapping
    public List<ShippingEntity> findAllShipping() {
        return shippingUseCase.findAllShipping();
    }

    @Operation(summary = "Update shipping")
    @PutMapping
    public ShippingEntity updateShipping(@RequestBody UpdateShippingRequest updateShippingRequest) throws Exception {
        return shippingUseCase.updateShipping(updateShippingRequest);
    }

    @Operation(summary = "Find shippings searching by any field")
    @GetMapping("/field/{shippingField}")
    public Page<ShippingEntity> findByAnyFields(@PathVariable String shippingField, Pageable pageable) {
        return shippingUseCase.findByAnyFields(shippingField, pageable);
    }

    @Operation(summary = "Delete shipping")
    @DeleteMapping("/{shippingId}")
    public ResponseEntity<Void> deleteShipping(@PathVariable String shippingId) throws Exception {
        return shippingUseCase.deleteShipping(shippingId);
    }

    @Operation(summary = "Find shipping by id")
    @GetMapping("/{shippingId}")
    public ShippingEntity findShippingById(@PathVariable String shippingId) throws Exception{
        return shippingUseCase.findShippingById(shippingId);
    }

    @Operation(summary = "Update shipping status")
    @PatchMapping("/status/{shippingId}")
    public ShippingEntity updateShippingStatus(@PathVariable String shippingId, @RequestParam ShippingStatusEnum shippingStatus) throws Exception {
        return shippingUseCase.updateShippingStatus(shippingId, shippingStatus);
    }
}