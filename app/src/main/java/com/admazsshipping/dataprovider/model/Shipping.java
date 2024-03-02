package com.admazsshipping.dataprovider.model;

import com.admazsshipping.entity.ShippingEntity;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Shipping {

    @Id
    private String id;
    private String recipientName;
    private String recipientAddress;
    private String shippingMethod;
    private String trackingNumber;
    private Date shippingDate;
    private Date expectedDeliveryDate;
    private Boolean isDelivered;

    // dimensions
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private Double dimensionalWeight;

    public Shipping() {

    }

    public double calculateDimensionalWeight() {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * 300;
        return Math.ceil(dimensionalWeight);
    }

    public double calculateShippingCost() {
        double dimensionalWeight = calculateDimensionalWeight();
        double shippingCost;
        // Example calculation (actual rates will vary)
        if (dimensionalWeight > weight) {
            shippingCost = dimensionalWeight * 1.5; // Example rate
        } else {
            shippingCost = weight * 1.5; // Example rate
        }
        return shippingCost;
    }

    public ShippingEntity toEntity(){
        return new ShippingEntity.ShippingBuilder()
                .id(this.getId())
                .recipientName(this.getRecipientName())
                .recipientAddress(this.getRecipientAddress())
                .shippingMethod(this.getShippingMethod())
                .trackingNumber(this.getTrackingNumber())
                .shippingDate(this.getShippingDate())
                .expectedDeliveryDate(this.getExpectedDeliveryDate())
                .isDelivered(this.getDelivered())
                .weight(this.getWeight())
                .length(this.getLength())
                .width(this.getWidth())
                .height(this.getHeight())
                .dimensionalWeight(this.getDimensionalWeight())
                .build();
    }

    public Shipping toShipping(ShippingEntity entity){
        return new Shipping(
                entity.getId(),
                entity.getRecipientName(),
                entity.getRecipientAddress(),
                entity.getShippingMethod(),
                entity.getTrackingNumber(),
                entity.getShippingDate(),
                entity.getExpectedDeliveryDate(),
                entity.getDelivered(),
                entity.getWeight(),
                entity.getLength(),
                entity.getWidth(),
                entity.getHeight(),
                entity.getDimensionalWeight()
        );
    }

    public Shipping(String id, String recipientName, String recipientAddress, String shippingMethod, String trackingNumber, Date shippingDate, Date expectedDeliveryDate, Boolean isDelivered, Double weight, Double length, Double width, Double height, Double dimensionalWeight) {
        this.id = id;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.shippingMethod = shippingMethod;
        this.trackingNumber = trackingNumber;
        this.shippingDate = shippingDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.isDelivered = isDelivered;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.dimensionalWeight = dimensionalWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDimensionalWeight() {
        return dimensionalWeight;
    }

    public void setDimensionalWeight(Double dimensionalWeight) {
        this.dimensionalWeight = dimensionalWeight;
    }
}
