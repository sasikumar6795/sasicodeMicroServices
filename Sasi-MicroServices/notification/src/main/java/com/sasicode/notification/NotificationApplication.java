package com.sasicode.notification;

import com.sasicode.amqp.RabbitMQMessageProducer;
import com.sasicode.notification.configuation.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
        "com.sasicode.notification",
        "com.sasicode.amqp"
})
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.sasicode.clients"
)
public class NotificationApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class,args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner (RabbitMQMessageProducer producer,
//                                         NotificationConfig notificationConfig) {
//        return args -> {
//            producer.publish(new Person("sasikumar",27),
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//
//    record Person(String name, int age){}
}
