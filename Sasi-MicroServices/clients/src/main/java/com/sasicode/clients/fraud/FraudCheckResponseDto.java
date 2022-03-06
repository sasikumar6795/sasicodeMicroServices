package com.sasicode.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FraudCheckResponseDto {

    private boolean isFraudster;
}
