package com.admazsshipping.entity.vo;

public class CargoPropertiesVO {

    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private Double cubageFactor;
    private Double dimensionalWeight;

    public CargoPropertiesVO(Double weight, Double length, Double width, Double height, Double cubageFactor, Double dimensionalWeight) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.cubageFactor = cubageFactor;
        this.dimensionalWeight = dimensionalWeight;
    }

    public CargoPropertiesVO() {
    }


    public static final class CargoPropertiesVOBuilder {
        private Double weight;
        private Double length;
        private Double width;
        private Double height;
        private Double cubageFactor;
        private Double dimensionalWeight;

        public CargoPropertiesVOBuilder() {
        }

        public static CargoPropertiesVOBuilder aCargoPropertiesVO() {
            return new CargoPropertiesVOBuilder();
        }

        public CargoPropertiesVOBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public CargoPropertiesVOBuilder length(Double length) {
            this.length = length;
            return this;
        }

        public CargoPropertiesVOBuilder width(Double width) {
            this.width = width;
            return this;
        }

        public CargoPropertiesVOBuilder height(Double height) {
            this.height = height;
            return this;
        }

        public CargoPropertiesVOBuilder cubageFactor(Double cubageFactor) {
            this.cubageFactor = cubageFactor;
            return this;
        }

        public CargoPropertiesVOBuilder dimensionalWeight(Double dimensionalWeight) {
            this.dimensionalWeight = dimensionalWeight;
            return this;
        }

        public CargoPropertiesVO build() {
            return new CargoPropertiesVO(weight, length, width, height, cubageFactor, dimensionalWeight);
        }
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

    public Double getCubageFactor() {
        return cubageFactor;
    }

    public void setCubageFactor(Double cubageFactor) {
        this.cubageFactor = cubageFactor;
    }

    public Double getDimensionalWeight() {
        return dimensionalWeight;
    }

    public void setDimensionalWeight(Double dimensionalWeight) {
        this.dimensionalWeight = dimensionalWeight;
    }
}
