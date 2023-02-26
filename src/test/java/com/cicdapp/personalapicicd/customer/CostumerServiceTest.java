package com.cicdapp.personalapicicd.customer;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CostumerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetAllCostumer() {
        Mockito.when(this.customerRepository.findAll())
               .thenReturn(costumers());
        List<Customer> costumers = this.customerService.getAllCostumer();
        Assertions.assertNotNull(costumers);
        Assertions.assertEquals(1, costumers.size());
    }

    @Test
    public void testGetCostumerById() {
        final Long TEST_ID = 1L;
        Mockito.when(this.customerRepository.findById(TEST_ID))
                .thenReturn(Optional.of(costumer()));
        CustomerDTO customer = this.customerService.getCostumerById(TEST_ID);
        Assertions.assertNotNull(costumers());
        Assertions.assertEquals(TEST_ID, customer.getId());
    }

    private List<Customer> costumers() {
        return List.of(costumer());
    }

    private Customer costumer() {
        Customer costumer = new Customer();
        costumer.setEmail("test@email.com");
        costumer.setId(1L);
        costumer.setGender("TEST");
        costumer.setFirstName("TEST");
        costumer.setLastName("TEST");
        return costumer;
    }
}