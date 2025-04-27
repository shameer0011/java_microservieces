package com.OrderServiece.OrderDemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderDTO {
    private Long productID;
    private String status;
    private String paymentMode;
    private Long quantity;
    private double amount;
}