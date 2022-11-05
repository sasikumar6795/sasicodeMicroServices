package com.sasicode.notification.rabbitMQ;

import com.sasicode.clients.notification.NotificationRequestDto;
import com.sasicode.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequestDto notificationRequestDto) {
        log.info("consumed {} from notifcation", notificationRequestDto);
        notificationService.send(notificationRequestDto);
    }
}
