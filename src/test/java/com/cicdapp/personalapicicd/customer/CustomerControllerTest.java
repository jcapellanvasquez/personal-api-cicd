package com.cicdapp.personalapicicd.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc client;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CustomerService customerService;

    @Test
    public void whenValidInput_thenReturnAllCustomers() throws Exception {
        Customer customer = customer();
        List<Customer> expectCustomers = List.of(customer);
        Mockito.when(customerService.getAllCostumer()).thenReturn(expectCustomers);

        MvcResult mvcResult = client.perform(get("/customer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String actualCustomers = mvcResult.getResponse().getContentAsString();
        assertThat(actualCustomers).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectCustomers));
    }

    @Test
    public void whenValidInput_thenReturnCustomerDTO() throws Exception {
        CustomerDTO customerDTO = customerDTO();
        Mockito.when(customerService.getCostumerById(anyLong()))
                .thenReturn(customerDTO);
        MvcResult mvcResult = client.perform(get("/customer/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        assertThat(actualResponseBody)
                .isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(customerDTO));
    }

    private Customer customer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        return customer;
    }

    private CustomerDTO customerDTO() {
        return CustomerDTO.convertCostumerToDTO(customer());
    }
}
