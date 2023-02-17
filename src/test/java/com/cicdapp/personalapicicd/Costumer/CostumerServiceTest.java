package com.cicdapp.personalapicicd.Costumer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CostumerServiceTest {
    @Mock
    private CostumerRepository costumerRepository;

    @InjectMocks
    private CostumerService costumerService;

    @Test
    public void testFindAll() {
        Mockito.when(this.costumerRepository.findAll())
               .thenReturn(costumers());
        List<Costumer> costumers = this.costumerService.getAllCostumer();
        Assertions.assertNotNull(costumers);
        Assertions.assertEquals(1, costumers.size());
    }

    private List<Costumer> costumers() {
        return List.of(costumer());
    }

    private Costumer costumer() {
        Costumer costumer = new Costumer();
        costumer.setEmail("test@email.com");
        costumer.setId(1L);
        costumer.setGender("TEST");
        costumer.setFirstName("TEST");
        costumer.setLastName("TEST");
        return costumer;
    }
}