package com.admazsshipping.entity.vo;

import java.util.Date;

public class UpdateShippingRequest {

    private String id;
    private String repicientName;
    private RecipientAddressVO recipientAddress;
    private ShippingMethodVO shippingMethod;
    private ShippingSelectedTypeEnum shippingSelectedType;
    private SaveCargoPropertiesRequest cargoPropertiesRequest;
    private Date expectedDeliveryDate;

    public UpdateShippingRequest(String id, String repicientName, RecipientAddressVO recipientAddress, ShippingMethodVO shippingMethod, ShippingSelectedTypeEnum shippingSelectedType, SaveCargoPropertiesRequest cargoPropertiesRequest, Date expectedDeliveryDate) {
        this.id = id;
        this.repicientName = repicientName;
        this.recipientAddress = recipientAddress;
        this.shippingMethod = shippingMethod;
        this.shippingSelectedType = shippingSelectedType;
        this.cargoPropertiesRequest = cargoPropertiesRequest;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public UpdateShippingRequest() {
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

    public void setCargoPropertiesRequest(SaveCargoPropertiesRequest cargoPropertiesRequest) {
        this.cargoPropertiesRequest = cargoPropertiesRequest;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
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

        public UpdateShippingRequestBuilder() {
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
            UpdateShippingRequest updateShippingRequest = new UpdateShippingRequest();
            updateShippingRequest.setId(id);
            updateShippingRequest.setRepicientName(repicientName);
            updateShippingRequest.setRecipientAddress(recipientAddress);
            updateShippingRequest.setShippingMethod(shippingMethod);
            updateShippingRequest.setShippingSelectedType(shippingSelectedType);
            updateShippingRequest.setCargoPropertiesRequest(cargoPropertiesRequest);
            updateShippingRequest.setExpectedDeliveryDate(expectedDeliveryDate);
            return updateShippingRequest;
        }
    }
}

