package com.sasicode.notification.controller;

import com.sasicode.clients.notification.NotificationRequestDto;
import com.sasicode.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequestDto notificationRequestDto) {
        log.info("New notification.....{}", notificationRequestDto);
        notificationService.send(notificationRequestDto);
    }
}
