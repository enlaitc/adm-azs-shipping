package com.admazsshipping.dataprovider.repository;

import com.admazsshipping.dataprovider.model.Shipping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends MongoRepository<Shipping, String> {

    @Query("{ $or: [ " +
            "{ 'recipientName': { $regex: ?0, $options: 'i' } }, " +
            "{ 'recipientAddress.streetName': { $regex: ?0, $options: 'i' } }, " +
            "{ 'recipientAddress.streetNumber': { $regex: ?0, $options: 'i' } }, " +
            "{ 'recipientAddress.suburb': { $regex: ?0, $options: 'i' } }, " +
            "{ 'recipientAddress.city': { $regex: ?0, $options: 'i' } }, " +
            "{ 'recipientAddress.state': { $regex: ?0, $options: 'i' } }, " +
            "{ 'recipientAddress.postcode': { $regex: ?0, $options: 'i' } }, " +
            "{ 'shippingMethod.cargoType': { $regex: ?0, $options: 'i' } }, " +
            "{ 'shippingMethod.vehicleType': { $regex: ?0, $options: 'i' } }, " +
            "{ 'shippingStatus': { $regex: ?0, $options: 'i' } }, " +
            "{ 'shippingSelectedType': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.weight': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.length': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.width': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.height': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.cubageFactor': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.dimensionalWeight': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cargoProperties.value': { $regex: ?0, $options: 'i' } }, " +
            "{ 'trackingNumber': { $regex: ?0, $options: 'i' } }, " +
            "{ 'shippingDate': { $regex: ?0, $options: 'i' } }, " +
            "{ 'shippingUpdateDate': { $regex: ?0, $options: 'i' } }, " +
            "{ 'expectedDeliveryDate': { $regex: ?0, $options: 'i' } } " +
            "] }")
    Page<Shipping> findByAnyFields(String searchTerm, Pageable pageable);
}