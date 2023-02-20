package com.cicdapp.personalapicicd.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CustomerController {
    private final CustomerService costumerService;

    public CustomerController(CustomerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> all() {
        return ResponseEntity.ok(this.costumerService.getAllCostumer());
    }
}
