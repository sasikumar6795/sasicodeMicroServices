package com.sasicode.customer.controller;

import com.sasicode.customer.entity.Customer;
import com.sasicode.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping
    public void registerCustomer(@RequestBody Customer customerRegisterRequest)
    {
        log.info("new Customer registration {}", customerRegisterRequest);
        customerService.registerCustomer(customerRegisterRequest);
    }
}
