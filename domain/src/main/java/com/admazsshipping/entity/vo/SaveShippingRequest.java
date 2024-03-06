package com.admazsshipping.entity.vo;

import java.util.Date;

public class SaveShippingRequest {

    private String recipientName;
    private RecipientAddressVO recipientAddress;
    private ShippingMethodVO shippingMethod;
    private ShippingSelectedTypeEnum shippingSelectedType;
    private SaveCargoPropertiesRequest cargoPropertiesRequest;
    private String trackingNumber;
    private Date expectedDeliveryDate;

    public SaveShippingRequest(String recipientName, RecipientAddressVO recipientAddress, ShippingMethodVO shippingMethod, ShippingSelectedTypeEnum shippingSelectedType, SaveCargoPropertiesRequest cargoPropertiesRequest, String trackingNumber, Date expectedDeliveryDate) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.shippingMethod = shippingMethod;
        this.shippingSelectedType = shippingSelectedType;
        this.cargoPropertiesRequest = cargoPropertiesRequest;
        this.trackingNumber = trackingNumber;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public SaveShippingRequest() {
    }


    public static final class SaveShippingRequestBuilder {
        private String recipientName;
        private RecipientAddressVO recipientAddress;
        private ShippingMethodVO shippingMethod;
        private ShippingSelectedTypeEnum shippingSelectedType;
        private SaveCargoPropertiesRequest cargoPropertiesRequest;
        private String trackingNumber;
        private Date expectedDeliveryDate;

        public SaveShippingRequestBuilder() {
        }

        public static SaveShippingRequestBuilder aSaveShippingRequest() {
            return new SaveShippingRequestBuilder();
        }

        public SaveShippingRequestBuilder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public SaveShippingRequestBuilder recipientAddress(RecipientAddressVO recipientAddress) {
            this.recipientAddress = recipientAddress;
            return this;
        }

        public SaveShippingRequestBuilder shippingMethod(ShippingMethodVO shippingMethod) {
            this.shippingMethod = shippingMethod;
            return this;
        }

        public SaveShippingRequestBuilder shippingSelectedType(ShippingSelectedTypeEnum shippingSelectedType) {
            this.shippingSelectedType = shippingSelectedType;
            return this;
        }

        public SaveShippingRequestBuilder cargoPropertiesRequest(SaveCargoPropertiesRequest cargoPropertiesRequest) {
            this.cargoPropertiesRequest = cargoPropertiesRequest;
            return this;
        }

        public SaveShippingRequestBuilder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public SaveShippingRequestBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public SaveShippingRequest build() {
            return new SaveShippingRequest(recipientName, recipientAddress, shippingMethod, shippingSelectedType, cargoPropertiesRequest, trackingNumber, expectedDeliveryDate);
        }
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

    public ShippingSelectedTypeEnum getShippingSelectedType() {
        return shippingSelectedType;
    }

    public void setShippingSelectedType(ShippingSelectedTypeEnum shippingSelectedType) {
        this.shippingSelectedType = shippingSelectedType;
    }

    public SaveCargoPropertiesRequest getCargoPropertiesRequest() {
        return cargoPropertiesRequest;
    }

    public void setCargoPropertiesRequest(SaveCargoPropertiesRequest cargoPropertiesRequest) {
        this.cargoPropertiesRequest = cargoPropertiesRequest;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}