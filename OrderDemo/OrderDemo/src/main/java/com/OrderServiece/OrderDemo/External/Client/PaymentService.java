package com.OrderServiece.OrderDemo.External.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.OrderServiece.OrderDemo.DTO.PaymentRequest;

// @CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PaymentServiceDemo", path = "/payment")
public interface PaymentService {
    @PostMapping("/create")
    public Long doPayment(@RequestBody PaymentRequest paymentDTO);
}
