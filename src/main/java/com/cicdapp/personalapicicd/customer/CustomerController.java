package com.cicdapp.personalapicicd.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService costumerService;
    public CustomerController(CustomerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> listAllCustomers() {
        return ResponseEntity.ok(this.costumerService.getAllCostumer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(this.costumerService.getCostumerById(id));
    }
}
