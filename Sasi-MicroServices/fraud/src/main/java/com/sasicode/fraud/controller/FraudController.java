package com.sasicode.fraud.controller;


import com.sasicode.fraud.dto.FraudCheckResponseDto;
import com.sasicode.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponseDto isFraudster(@PathVariable("customerId") Integer customerId)
    {
        boolean isFraudlentCustomer = fraudCheckService.isFraudsterCustomer(customerId);
        return new FraudCheckResponseDto(isFraudlentCustomer);
    }

}
