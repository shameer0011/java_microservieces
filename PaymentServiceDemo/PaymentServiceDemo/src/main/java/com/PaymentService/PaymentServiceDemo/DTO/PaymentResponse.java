package com.PaymentService.PaymentServiceDemo.DTO;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private long paymentId;
    private String paymentStatus;
    private String paymentMethod;
    private double paymentAmount;
    private Instant paymentDate;
    private Long orderId;
}
