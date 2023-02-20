package com.cicdapp.personalapicicd.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository costumerRepository;

    public CustomerService(CustomerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Customer> getAllCostumer() {
        return this.costumerRepository.findAll();
    }
}
