package com.sasicode.notification.service;

import com.sasicode.clients.notification.NotificationRequestDto;
import com.sasicode.notification.entity.Notification;
import com.sasicode.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequestDto notificationRequestDto) {

        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequestDto.getToCustomerId())
                .toCustomerEmail(notificationRequestDto.getToCustomerEmail())
                .sender("sasikumar")
                .message(notificationRequestDto.getMessage())
                .sentAt(LocalDateTime.now())
                .build());

    }
}
