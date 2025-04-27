package com.ProductServiece.ProductDemo.External.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OrderDemo", path = "/api/orders")
public interface OrderService {
    @GetMapping("/getDetails")
    public String getDetails();
}
