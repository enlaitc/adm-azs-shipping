package com.admazsshipping.entity;

import com.admazsshipping.entity.vo.*;

import java.util.Date;

public class ShippingEntity {

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

    public ShippingEntity(String id, String recipientName, RecipientAddressVO recipientAddress, ShippingMethodVO shippingMethod, ShippingStatusEnum shippingStatus, ShippingSelectedTypeEnum shippingSelectedType, CargoPropertiesVO cargoProperties, String trackingNumber, Date shippingDate, Date shippingUpdateDate, Date expectedDeliveryDate) {
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

    public ShippingEntity() {
    }

    public static final class ShippingEntityBuilder {
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

        public ShippingEntityBuilder() {
        }

        public static ShippingEntityBuilder aShippingEntity() {
            return new ShippingEntityBuilder();
        }

        public ShippingEntityBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ShippingEntityBuilder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public ShippingEntityBuilder recipientAddress(RecipientAddressVO recipientAddress) {
            this.recipientAddress = recipientAddress;
            return this;
        }

        public ShippingEntityBuilder shippingMethod(ShippingMethodVO shippingMethod) {
            this.shippingMethod = shippingMethod;
            return this;
        }

        public ShippingEntityBuilder shippingStatus(ShippingStatusEnum shippingStatus) {
            this.shippingStatus = shippingStatus;
            return this;
        }

        public ShippingEntityBuilder shippingSelectedType(ShippingSelectedTypeEnum shippingSelectedType) {
            this.shippingSelectedType = shippingSelectedType;
            return this;
        }

        public ShippingEntityBuilder cargoProperties(CargoPropertiesVO cargoProperties) {
            this.cargoProperties = cargoProperties;
            return this;
        }

        public ShippingEntityBuilder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public ShippingEntityBuilder shippingDate(Date shippingDate) {
            this.shippingDate = shippingDate;
            return this;
        }

        public ShippingEntityBuilder shippingUpdateDate(Date shippingUpdateDate) {
            this.shippingUpdateDate = shippingUpdateDate;
            return this;
        }

        public ShippingEntityBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public ShippingEntity build() {
            return new ShippingEntity(id, recipientName, recipientAddress, shippingMethod, shippingStatus, shippingSelectedType, cargoProperties, trackingNumber, shippingDate, shippingUpdateDate, expectedDeliveryDate);
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