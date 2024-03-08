package com.admazsshipping.entrypoint.http;

import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.SaveShippingRequest;
import com.admazsshipping.entity.vo.ShippingStatusEnum;
import com.admazsshipping.entity.vo.UpdateShippingRequest;
import com.admazsshipping.usecase.ShippingUseCase;
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

    @PostMapping
    public ShippingEntity saveShipping(@Valid @RequestBody SaveShippingRequest shippingRequest) throws Exception {
        return shippingUseCase.saveShipping(shippingRequest);
    }

    @GetMapping
    public List<ShippingEntity> findAllShipping() {
        return shippingUseCase.findAllShipping();
    }

    @PutMapping
    public ShippingEntity updateShipping(@RequestBody UpdateShippingRequest updateShippingRequest) throws Exception {
        return shippingUseCase.updateShipping(updateShippingRequest);
    }

    @GetMapping("/field/{shippingField}")
    public Page<ShippingEntity> findByAnyFields(@PathVariable String shippingField, Pageable pageable) {
        return shippingUseCase.findByAnyFields(shippingField, pageable);
    }

    @DeleteMapping("/{shippingId}")
    public ResponseEntity<Void> deleteShipping(@PathVariable String shippingId) throws Exception {
        return shippingUseCase.deleteShipping(shippingId);
    }

    @GetMapping("/{shippingId}")
    public ShippingEntity findShippingById(@PathVariable String shippingId) throws Exception{
        return shippingUseCase.findShippingById(shippingId);
    }

    @PatchMapping("/status/{shippingId}")
    public ShippingEntity updateShippingStatus(@PathVariable String shippingId, @RequestBody ShippingStatusEnum shippingStatus) throws Exception {
        return shippingUseCase.updateShippingStatus(shippingId, shippingStatus);
    }
}