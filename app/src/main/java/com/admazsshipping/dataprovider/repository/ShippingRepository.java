package com.admazsshipping.dataprovider.repository;

import com.admazsshipping.dataprovider.model.Shipping;
import com.admazsshipping.entity.ShippingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends MongoRepository<Shipping, String> {

}