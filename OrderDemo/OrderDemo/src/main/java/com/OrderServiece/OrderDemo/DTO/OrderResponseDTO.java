package com.OrderServiece.OrderDemo.DTO;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Long orderId;
    private Instant orderDate;
    private String orderStatus;
    private double amount;
    private ProductResponse productResponse; // Make sure this is lowercase
    private PaymentResponse paymentResponse;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductResponse { // Made this class static
        private Long productId;
        private Long price;
        private String name;
        private Long quantity;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PaymentResponse {
        private long paymentId;
        private String paymentStatus;
        private String paymentMethod;
        private double paymentAmount;
        private Instant paymentDate;
        private Long orderId;
    }
}
