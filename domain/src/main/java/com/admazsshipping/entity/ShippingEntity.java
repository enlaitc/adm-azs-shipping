package com.admazsshipping.entity;

import java.util.Date;

public class ShippingEntity {

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

    public ShippingEntity() {

    }

    private ShippingEntity(String id, String recipientName, String recipientAddress, String shippingMethod, String trackingNumber, Date shippingDate, Date expectedDeliveryDate, Boolean isDelivered, Double weight, Double length, Double width, Double height, Double dimensionalWeight) {
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

    public static class ShippingBuilder {
        private String id;
        private String recipientName;
        private String recipientAddress;
        private String shippingMethod;
        private String trackingNumber;
        private Date shippingDate;
        private Date expectedDeliveryDate;
        private Boolean isDelivered;
        private Double weight;
        private Double length;
        private Double width;
        private Double height;
        private Double dimensionalWeight;

        public ShippingBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ShippingBuilder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public ShippingBuilder recipientAddress(String recipientAddress) {
            this.recipientAddress = recipientAddress;
            return this;
        }

        public ShippingBuilder shippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
            return this;
        }

        public ShippingBuilder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public ShippingBuilder shippingDate(Date shippingDate) {
            this.shippingDate = shippingDate;
            return this;
        }

        public ShippingBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public ShippingBuilder isDelivered(Boolean isDelivered) {
            this.isDelivered = isDelivered;
            return this;
        }

        public ShippingBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public ShippingBuilder length(Double length) {
            this.length = length;
            return this;
        }

        public ShippingBuilder width(Double width) {
            this.width = width;
            return this;
        }

        public ShippingBuilder height(Double height) {
            this.height = height;
            return this;
        }

        public ShippingBuilder dimensionalWeight(Double dimensionalWeight) {
            this.dimensionalWeight = dimensionalWeight;
            return this;
        }

        public ShippingEntity build(){
            return new ShippingEntity(id, recipientName,recipientAddress,shippingMethod,trackingNumber,shippingDate,expectedDeliveryDate,isDelivered,weight,length,width,height,dimensionalWeight);
        }
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