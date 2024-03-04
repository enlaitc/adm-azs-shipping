package com.admazsshipping.entity.vo;

import java.util.Date;

public class UpdateShippingRequest {

    public String id;
    public String repicientName;
    public RecipientAddressVO recipientAddress;
    public ShippingMethodVO shippingMethod;
    public ShippingSelectedTypeEnum shippingSelectedType;
    public SaveCargoPropertiesRequest cargoPropertiesRequest;
    public Date expectedDeliveryDate;

    public UpdateShippingRequest(String id, String repicientName, RecipientAddressVO recipientAddress, ShippingMethodVO shippingMethod, ShippingSelectedTypeEnum shippingSelectedType, SaveCargoPropertiesRequest cargoPropertiesRequest, Date expectedDeliveryDate) {
        this.id = id;
        this.repicientName = repicientName;
        this.recipientAddress = recipientAddress;
        this.shippingMethod = shippingMethod;
        this.shippingSelectedType = shippingSelectedType;
        this.cargoPropertiesRequest = cargoPropertiesRequest;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }


    public static final class UpdateShippingRequestBuilder {

        private String id;
        private String repicientName;
        private RecipientAddressVO recipientAddress;
        private ShippingMethodVO shippingMethod;
        private ShippingSelectedTypeEnum shippingSelectedType;
        private SaveCargoPropertiesRequest cargoPropertiesRequest;
        private Date expectedDeliveryDate;

        private UpdateShippingRequestBuilder() {
        }

        public static UpdateShippingRequestBuilder anUpdateShippingRequest() {
            return new UpdateShippingRequestBuilder();
        }


        public UpdateShippingRequestBuilder id(String id) {
            this.id = id;
            return this;
        }
        public UpdateShippingRequestBuilder repicientName(String repicientName) {
            this.repicientName = repicientName;
            return this;
        }

        public UpdateShippingRequestBuilder recipientAddress(RecipientAddressVO recipientAddress) {
            this.recipientAddress = recipientAddress;
            return this;
        }

        public UpdateShippingRequestBuilder shippingMethod(ShippingMethodVO shippingMethod) {
            this.shippingMethod = shippingMethod;
            return this;
        }

        public UpdateShippingRequestBuilder shippingSelectedType(ShippingSelectedTypeEnum shippingSelectedType) {
            this.shippingSelectedType = shippingSelectedType;
            return this;
        }

        public UpdateShippingRequestBuilder cargoPropertiesRequest(SaveCargoPropertiesRequest cargoPropertiesRequest) {
            this.cargoPropertiesRequest = cargoPropertiesRequest;
            return this;
        }

        public UpdateShippingRequestBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public UpdateShippingRequest build() {
            return new UpdateShippingRequest(id, repicientName, recipientAddress, shippingMethod, shippingSelectedType, cargoPropertiesRequest, expectedDeliveryDate);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepicientName() {
        return repicientName;
    }

    public void setRepicientName(String repicientName) {
        this.repicientName = repicientName;
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

    public void setCargoProperties(SaveCargoPropertiesRequest cargoPropertiesRequest) {
        this.cargoPropertiesRequest = cargoPropertiesRequest;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}

