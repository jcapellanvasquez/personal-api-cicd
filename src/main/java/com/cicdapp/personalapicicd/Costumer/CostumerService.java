package com.cicdapp.personalapicicd.Costumer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerService {
    private final CostumerRepository costumerRepository;

    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Costumer> getAllCostumer() {
        return this.costumerRepository.findAll();
    }
}
