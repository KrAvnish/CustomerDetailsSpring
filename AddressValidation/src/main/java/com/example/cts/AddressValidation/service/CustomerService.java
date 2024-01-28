package com.example.cts.AddressValidation.service;

import com.example.cts.AddressValidation.model.Model;
import com.example.cts.AddressValidation.model.ValidationResponse;

public interface CustomerService {
    ValidationResponse validateCustomerDetails(Model model);
    void saveCustomer(Model model);
}
