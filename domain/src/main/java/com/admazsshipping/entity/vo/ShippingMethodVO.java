package com.admazsshipping.entity.vo;

public class ShippingMethodVO {

    private CargoTypeEnum cargoType;
    private VehicleTypeEnum vehicleType;


    public ShippingMethodVO(CargoTypeEnum cargoType, VehicleTypeEnum vehicleType) {
        this.cargoType = cargoType;
        this.vehicleType = vehicleType;
    }

    public ShippingMethodVO() {
    }

    public CargoTypeEnum getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoTypeEnum cargoType) {
        this.cargoType = cargoType;
    }

    public VehicleTypeEnum getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeEnum vehicleType) {
        this.vehicleType = vehicleType;
    }
}
