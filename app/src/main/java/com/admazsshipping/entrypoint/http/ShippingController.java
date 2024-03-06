package com.admazsshipping.entrypoint.http;

import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.SaveShippingRequest;
import com.admazsshipping.entity.vo.UpdateShippingRequest;
import com.admazsshipping.usecase.ShippingUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/shipping")
public class ShippingController {


    @Autowired
    private ShippingUseCase shippingUseCase;

    @PostMapping
    public ShippingEntity saveShipping(@RequestBody SaveShippingRequest shippingRequest) {
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

    @GetMapping("/{field}")
    public Page<ShippingEntity> findByAnyFields(@PathVariable String field, Pageable pageable){
        return shippingUseCase.findByAnyFields(field, pageable);
    }

    @PatchMapping("/cancel/{shippingId}")
    public ShippingEntity cancelShipping(@PathVariable String shippingId) throws Exception {
        return shippingUseCase.cancelShipping(shippingId);
    }

    @DeleteMapping("/{shippingId}")
    public ResponseEntity<Void> deleteShipping(@PathVariable String shippingId) throws Exception {
        return shippingUseCase.deleteShipping(shippingId);
    }
}