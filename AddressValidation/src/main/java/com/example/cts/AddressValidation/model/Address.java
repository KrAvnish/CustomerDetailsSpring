package com.example.cts.AddressValidation.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @NotBlank(message = "streetNumber is mandatory")
    private String streetNumber;
    @NotBlank(message = "streetName is mandatory")
    private String streetName;
    @NotBlank(message = "city is mandatory")
    private String city;
    @NotBlank(message = "state is mandatory")
    private String state;
    @NotBlank(message = "zipCode is mandatory")
    private String zipCode;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
