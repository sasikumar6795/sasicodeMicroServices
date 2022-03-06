package com.sasicode.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.sasicode.fraud"
})
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.sasicode.clients"
)
public class FraudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class,args);
    }
}
