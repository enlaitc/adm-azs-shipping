package com.admazsshipping.entrypoint.http;

import com.admazsshipping.dataprovider.model.Shipping;
import com.admazsshipping.dataprovider.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/shipping")
public class ShippingController {


    @Autowired
    private ShippingRepository repository;

    @PostMapping("/save")
    public Shipping saveShipping(@RequestBody Shipping shipping) {
        return repository.save(shipping);
    }

    @GetMapping("/ships")
    public List<Shipping> findAllShipping() {
        List<Shipping> shippings =  repository.findAll();
        System.out.println(shippings);
        return shippings;
    }
}