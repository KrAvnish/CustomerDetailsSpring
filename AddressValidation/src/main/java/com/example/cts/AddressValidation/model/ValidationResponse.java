package com.example.cts.AddressValidation.model;

import lombok.Data;

@Data
public class ValidationResponse {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
