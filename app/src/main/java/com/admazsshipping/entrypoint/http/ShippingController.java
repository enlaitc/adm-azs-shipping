package com.admazsshipping.entrypoint.http;

import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.SaveShippingRequest;
import com.admazsshipping.entity.vo.UpdateShippingRequest;
import com.admazsshipping.usecase.ShippingUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/all")
    public List<ShippingEntity> findAllShipping() {
        return shippingUseCase.findAllShipping();
    }

    @PutMapping("/update")
    public ShippingEntity updateShipping(@RequestBody UpdateShippingRequest updateShippingRequest) throws Exception {
        return shippingUseCase.updateShipping(updateShippingRequest);
    }
}