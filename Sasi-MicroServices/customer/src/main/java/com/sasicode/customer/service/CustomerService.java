package com.sasicode.customer.service;

import com.sasicode.clients.fraud.FraudCheckResponseDto;
import com.sasicode.clients.fraud.FraudClient;
import com.sasicode.customer.entity.Customer;
import com.sasicode.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    //private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
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

        //Rest template code
//        FraudCheckResponseDto fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponseDto.class,
//                customer.getId()
//        );

        FraudCheckResponseDto fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(Objects.requireNonNull(fraudCheckResponse).isFraudster())
        {
            throw new IllegalStateException("fraudster");
        }
        // send notification
    }


}
