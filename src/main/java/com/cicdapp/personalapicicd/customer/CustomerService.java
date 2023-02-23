package com.cicdapp.personalapicicd.customer;

import com.cicdapp.personalapicicd.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private final CustomerRepository costumerRepository;

    public CustomerService(CustomerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Customer> getAllCostumer() {
        return this.costumerRepository.findAll();
    }
    public CustomerDTO getCostumerById(Long id) throws NoSuchElementException {
        return this.costumerRepository.findById(id)
                .map(CustomerDTO::convertCostumerToDTO)
                .orElseThrow(() -> new NoSuchElementException("Costumer: " + id + " not found"));
    }
}
