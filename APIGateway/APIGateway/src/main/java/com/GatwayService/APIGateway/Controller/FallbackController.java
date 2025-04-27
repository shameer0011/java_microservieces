package com.GatwayService.APIGateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/order")
    public String orderServiecFallback() {
        return "Order Service is not available";
    }

    @GetMapping("/fallback/payment")
    public String paymentServiecFallback() {
        return "Payment Service is not available";
    }

    @GetMapping("/fallback/product")
    public String productServiecFallback() {
        return "Product Service is not available";
    }

}
