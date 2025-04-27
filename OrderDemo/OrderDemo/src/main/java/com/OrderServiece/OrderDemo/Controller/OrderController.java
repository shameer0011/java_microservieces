package com.OrderServiece.OrderDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderServiece.OrderDemo.DTO.CreateOrderDTO;
import com.OrderServiece.OrderDemo.DTO.OrderResponseDTO;
import com.OrderServiece.OrderDemo.Service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/orders")
@Log4j2
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAuthority('Customer')")
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderDTO orderRequestDTO) {
        log.info("Received order request: {}", orderRequestDTO);
        Long id = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>("Order id " + id + " has been created successfully!", HttpStatus.OK);

    }
    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/get_order/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable Long id) {
        log.info("Received order id: {}", id);
        OrderResponseDTO order = orderService.getOrders(id);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // For testing purpose communicate paroduct and order
    @GetMapping("/getDetails")
    public String getDetails() {
        log.info("Received order request: {}");
        return "Product has been created successfully!";
    }
}
