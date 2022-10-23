package com.sasicode.clients.notification;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NotificationRequestDto {
    Integer toCustomerId;
    String toCustomerEmail;
    String message;
}
