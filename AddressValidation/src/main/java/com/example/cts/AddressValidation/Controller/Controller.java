package com.example.cts.AddressValidation.Controller;

import com.example.cts.AddressValidation.model.Model;
import com.example.cts.AddressValidation.model.ValidationResponse;
import com.example.cts.AddressValidation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/validate")
    public ResponseEntity<Object> validateCustomerDetails(@RequestBody Model model){
        ValidationResponse validationResponse = customerService.validateCustomerDetails(model);

        customerService.saveCustomer(model);

        return ResponseEntity.status(HttpStatus.OK).body(validationResponse);
    }
}