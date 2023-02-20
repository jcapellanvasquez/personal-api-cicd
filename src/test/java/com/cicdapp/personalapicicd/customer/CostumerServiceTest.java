package com.cicdapp.personalapicicd.customer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CostumerServiceTest {
    @Mock
    private CustomerRepository costumerRepository;

    @InjectMocks
    private CustomerService costumerService;

    @Test
    public void testFindAll() {
        Mockito.when(this.costumerRepository.findAll())
               .thenReturn(costumers());
        List<Customer> costumers = this.costumerService.getAllCostumer();
        Assertions.assertNotNull(costumers);
        Assertions.assertEquals(1, costumers.size());
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