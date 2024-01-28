package com.example.cts.AddressValidation.service;

import com.example.cts.AddressValidation.model.Address;
import com.example.cts.AddressValidation.model.Model;
import com.example.cts.AddressValidation.model.ValidationResponse;
import com.example.cts.AddressValidation.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private ValidationRepository validationRepository;
    @Override
    public ValidationResponse validateCustomerDetails(Model model) {
        ValidationResponse response = new ValidationResponse();

        if(isValidName(model.getFirstName()) && isValidName(model.getLastName())
                && isValidAddress(model.getAddress())){
            response.setStatus("success");
        }
        else{
            response.setStatus("failure");
        }

        validationRepository.save(model);
        validationRepository.flush();

        return response;
    }

    @Override
    @Transactional
    public void saveCustomer(Model model) {
        validationRepository.save(model);
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private boolean isValidAddress(Address address) {
        return isNumeric(address.getStreetNumber())
                && !address.getStreetName().isEmpty()
                && !address.getCity().isEmpty()
                && !address.getState().isEmpty()
                && isNumeric(address.getZipCode());
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
