package com.cicdapp.personalapicicd.customer;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    public static CustomerDTO convertCostumerToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setGender(customer.getGender());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setFirstName(customer.getFirstName());
        return customerDTO;
    }
}
