package com.admazsshipping.entity.vo;

public class RecipientAddressVO {

    private String streetName;
    private String streetNumber;
    private String suburb;
    private String city;
    private String state;
    private int postcode;

    public RecipientAddressVO(String streetName, String streetNumber, String suburb, String city, String state, int postcode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }

    public RecipientAddressVO() {
    }


    public static final class RecipientAddressVOBuilder {
        private String streetName;
        private String streetNumber;
        private String suburb;
        private String city;
        private String state;
        private int postcode;

        private RecipientAddressVOBuilder() {
        }

        public static RecipientAddressVOBuilder aRecipientAddressVO() {
            return new RecipientAddressVOBuilder();
        }

        public RecipientAddressVOBuilder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public RecipientAddressVOBuilder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public RecipientAddressVOBuilder suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public RecipientAddressVOBuilder city(String city) {
            this.city = city;
            return this;
        }

        public RecipientAddressVOBuilder state(String state) {
            this.state = state;
            return this;
        }

        public RecipientAddressVOBuilder postcode(int postcode) {
            this.postcode = postcode;
            return this;
        }

        public RecipientAddressVO build() {
            return new RecipientAddressVO(streetName, streetNumber, suburb, city, state, postcode);
        }
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
