package com.admazsshipping.entity.vo;

public class SaveCargoPropertiesRequest {
    protected Double weight = (double) 0;
    private Double length = (double) 0;
    private Double width = (double) 0;
    private Double height = (double) 0;
    private Double cubageFactor;

    public SaveCargoPropertiesRequest(Double weight, Double length, Double width, Double height, Double cubageFactor) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.cubageFactor = cubageFactor;
    }

    public SaveCargoPropertiesRequest() {
    }


    public static final class SaveCargoPropertiesRequestBuilder {
        private Double weight;
        private Double length;
        private Double width;
        private Double height;
        private Double cubageFactor;

        private SaveCargoPropertiesRequestBuilder() {
        }

        public static SaveCargoPropertiesRequestBuilder aSaveCargoPropertiesRequest() {
            return new SaveCargoPropertiesRequestBuilder();
        }

        public SaveCargoPropertiesRequestBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public SaveCargoPropertiesRequestBuilder length(Double length) {
            this.length = length;
            return this;
        }

        public SaveCargoPropertiesRequestBuilder width(Double width) {
            this.width = width;
            return this;
        }

        public SaveCargoPropertiesRequestBuilder height(Double height) {
            this.height = height;
            return this;
        }

        public SaveCargoPropertiesRequestBuilder cubageFactor(Double cubageFactor) {
            this.cubageFactor = cubageFactor;
            return this;
        }

        public SaveCargoPropertiesRequest build() {
            return new SaveCargoPropertiesRequest(weight, length, width, height, cubageFactor);
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
}
