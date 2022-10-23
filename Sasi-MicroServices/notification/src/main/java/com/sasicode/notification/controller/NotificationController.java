package com.sasicode.notification.controller;

import com.sasicode.clients.notification.NotificationRequestDto;
import com.sasicode.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequestDto notificationRequestDto) {
        log.info("New notification.....{}", notificationRequestDto);
        notificationService.send(notificationRequestDto);
    }
}
