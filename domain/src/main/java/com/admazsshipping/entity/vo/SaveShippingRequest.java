package com.admazsshipping.entity.vo;

import java.util.Date;

public class SaveShippingRequest {

    private String recipientName;
    private String recipientAddress;
    private String shippingMethod;
    private String trackingNumber;
    private Date shippingDate;
    private Date expectedDeliveryDate;

    // dimensions
    private Double weight;
    private Double length;
    private Double width;
    private Double height;

    public SaveShippingRequest() {
    }

    public SaveShippingRequest(String recipientName, String recipientAddress, String shippingMethod, String trackingNumber, Date shippingDate, Date expectedDeliveryDate, Double weight, Double length, Double width, Double height) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.shippingMethod = shippingMethod;
        this.trackingNumber = trackingNumber;
        this.shippingDate = shippingDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
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

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}
