package com.admazsshipping.entrypoint.http;

import com.admazsshipping.dataprovider.model.Shipping;
import com.admazsshipping.dataprovider.repository.ShippingRepository;
import com.admazsshipping.entity.ShippingEntity;
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
    public ShippingEntity saveShipping(@RequestBody ShippingEntity shipping) {
        return shippingUseCase.saveShipping(shipping);
    }

    @GetMapping("/all")
    public List<ShippingEntity> findAllShipping() {
        return shippingUseCase.findAllShipping();
    }
}