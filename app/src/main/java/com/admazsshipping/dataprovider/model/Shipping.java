package com.admazsshipping.dataprovider.model;

import com.admazsshipping.entity.ShippingEntity;
import com.admazsshipping.entity.vo.*;

import java.util.Date;

public class Shipping {

    private String id;
    private String recipientName;
    private RecipientAddressVO recipientAddress;
    private ShippingMethodVO shippingMethod;
    private ShippingStatusEnum shippingStatus;
    private ShippingSelectedTypeEnum shippingSelectedType;
    private CargoPropertiesVO cargoProperties;
    private String trackingNumber;
    private Date shippingDate;
    private Date shippingUpdateDate;
    private Date expectedDeliveryDate;


    public Shipping(String id, String recipientName, RecipientAddressVO recipientAddress, ShippingMethodVO shippingMethod, ShippingStatusEnum shippingStatus, ShippingSelectedTypeEnum shippingSelectedType, CargoPropertiesVO cargoProperties, String trackingNumber, Date shippingDate, Date shippingUpdateDate, Date expectedDeliveryDate) {
        this.id = id;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.shippingMethod = shippingMethod;
        this.shippingStatus = shippingStatus;
        this.shippingSelectedType = shippingSelectedType;
        this.cargoProperties = cargoProperties;
        this.trackingNumber = trackingNumber;
        this.shippingDate = shippingDate;
        this.shippingUpdateDate = shippingUpdateDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Shipping() {
    }

    public ShippingEntity toEntity(){
        return new ShippingEntity.ShippingEntityBuilder()
                .id(this.getId())
                .recipientName(this.getRecipientName())
                .recipientAddress(this.getRecipientAddress())
                .shippingMethod(this.getShippingMethod())
                .shippingStatus(this.getShippingStatus())
                .shippingSelectedType(this.getShippingSelectedType())
                .cargoProperties(this.getCargoProperties())
                .trackingNumber(this.getTrackingNumber())
                .shippingDate(this.getShippingDate())
                .shippingUpdateDate(this.getShippingUpdateDate())
                .expectedDeliveryDate(this.getExpectedDeliveryDate())
                .build();
    }

    public Shipping toShipping(ShippingEntity entity){
        return new Shipping.ShippingBuilder()
                .id(entity.getId())
                .recipientName(entity.getRecipientName())
                .recipientAddress(entity.getRecipientAddress())
                .shippingMethod(entity.getShippingMethod())
                .shippingStatus(entity.getShippingStatus())
                .shippingSelectedType(entity.getShippingSelectedType())
                .cargoProperties(entity.getCargoProperties())
                .trackingNumber(entity.getTrackingNumber())
                .shippingDate(entity.getShippingDate())
                .shippingUpdateDate(entity.getShippingUpdateDate())
                .expectedDeliveryDate(entity.getExpectedDeliveryDate())
                .build();
    }

    public static final class ShippingBuilder {
        private String id;
        private String recipientName;
        private RecipientAddressVO recipientAddress;
        private ShippingMethodVO shippingMethod;
        private ShippingStatusEnum shippingStatus;
        private ShippingSelectedTypeEnum shippingSelectedType;
        private CargoPropertiesVO cargoProperties;
        private String trackingNumber;
        private Date shippingDate;
        private Date shippingUpdateDate;
        private Date expectedDeliveryDate;

        private ShippingBuilder() {
        }

        public static ShippingBuilder aShipping() {
            return new ShippingBuilder();
        }

        public ShippingBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ShippingBuilder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public ShippingBuilder recipientAddress(RecipientAddressVO recipientAddress) {
            this.recipientAddress = recipientAddress;
            return this;
        }

        public ShippingBuilder shippingMethod(ShippingMethodVO shippingMethod) {
            this.shippingMethod = shippingMethod;
            return this;
        }

        public ShippingBuilder shippingStatus(ShippingStatusEnum shippingStatus) {
            this.shippingStatus = shippingStatus;
            return this;
        }

        public ShippingBuilder shippingSelectedType(ShippingSelectedTypeEnum shippingSelectedType) {
            this.shippingSelectedType = shippingSelectedType;
            return this;
        }

        public ShippingBuilder cargoProperties(CargoPropertiesVO cargoProperties) {
            this.cargoProperties = cargoProperties;
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

        public ShippingBuilder shippingUpdateDate(Date shippingUpdateDate) {
            this.shippingUpdateDate = shippingUpdateDate;
            return this;
        }

        public ShippingBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public Shipping build() {
            return new Shipping(id, recipientName, recipientAddress, shippingMethod, shippingStatus, shippingSelectedType, cargoProperties, trackingNumber, shippingDate, shippingUpdateDate, expectedDeliveryDate);
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

    public RecipientAddressVO getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(RecipientAddressVO recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public ShippingMethodVO getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethodVO shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public ShippingStatusEnum getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatusEnum shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public ShippingSelectedTypeEnum getShippingSelectedType() {
        return shippingSelectedType;
    }

    public void setShippingSelectedType(ShippingSelectedTypeEnum shippingSelectedType) {
        this.shippingSelectedType = shippingSelectedType;
    }

    public CargoPropertiesVO getCargoProperties() {
        return cargoProperties;
    }

    public void setCargoProperties(CargoPropertiesVO cargoProperties) {
        this.cargoProperties = cargoProperties;
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

    public Date getShippingUpdateDate() {
        return shippingUpdateDate;
    }

    public void setShippingUpdateDate(Date shippingUpdateDate) {
        this.shippingUpdateDate = shippingUpdateDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}