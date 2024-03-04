package com.admazsshipping.entity.vo;

public enum CargoPropertiesSaveMapper {

    INSTANCE;

    public CargoPropertiesVO toCargoProperties(SaveCargoPropertiesRequest cargoPropertiesRequest) {

        if (cargoPropertiesRequest == null) return null;

        CargoPropertiesVO cargoProperties = new CargoPropertiesVO.CargoPropertiesVOBuilder()
                .weight(cargoPropertiesRequest.getWeight())
                .length(cargoPropertiesRequest.getLength())
                .width(cargoPropertiesRequest.getWidth())
                .height(cargoPropertiesRequest.getHeight())
                .cubageFactor(cargoPropertiesRequest.getCubageFactor())
                .dimensionalWeight(calculateDimensionalWeight(
                        cargoPropertiesRequest.getLength(),
                        cargoPropertiesRequest.getLength(),
                        cargoPropertiesRequest.getHeight())
                )
                .build();
        return cargoProperties;
    }

    private double calculateDimensionalWeight(Double length, Double width, Double height) {
        double volume = (length / 100) * (width / 100) * (height / 100);
        double dimensionalWeight = volume * 300;
        return Math.round(dimensionalWeight * 100.0) / 100.0;
    }
}
