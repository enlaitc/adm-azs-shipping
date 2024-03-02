package com.admazsshipping.entity.vo;

public class ShippingMethodVO {

    private String cargoType;
    private String vehicleType;


    public ShippingMethodVO(String cargoType, String vehicleType) {
        this.cargoType = cargoType;
        this.vehicleType = vehicleType;
    }

    public ShippingMethodVO() {
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
