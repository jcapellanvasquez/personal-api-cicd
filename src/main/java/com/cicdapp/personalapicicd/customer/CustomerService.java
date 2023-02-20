package com.cicdapp.personalapicicd.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class CustomerService {
    private final CustomerRepository costumerRepository;

    public CustomerService(CustomerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Customer> getAllCostumer() {
        return this.costumerRepository.findAll();
    }
    public Customer getCostumer(Long id) throws NoSuchElementException {
        return this.costumerRepository.findById(id).get();
    }
}
