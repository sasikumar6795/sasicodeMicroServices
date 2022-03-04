package com.sasicode.customer.service;

import com.sasicode.customer.dto.FraudCheckResponseDto;
import com.sasicode.customer.entity.Customer;
import com.sasicode.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(Customer request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // to check if email valid
        // to check if email not taken
        // to check if fraudster

        customerRepository.saveAndFlush(customer);


        FraudCheckResponseDto fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponseDto.class,
                customer.getId()
        );

        if(Objects.requireNonNull(fraudCheckResponse).isFraudster())
        {
            throw new IllegalStateException("fraudster");
        }
        // send notification
    }


}
