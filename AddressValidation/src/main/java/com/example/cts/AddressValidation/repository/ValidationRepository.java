package com.example.cts.AddressValidation.repository;

import com.example.cts.AddressValidation.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Model, Long> {

}