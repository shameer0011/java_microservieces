package com.PaymentService.PaymentServiceDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PaymentService.PaymentServiceDemo.DTO.PaymentRequestDTO;
import com.PaymentService.PaymentServiceDemo.DTO.PaymentResponse;
import com.PaymentService.PaymentServiceDemo.Serviece.PaymentService;

@RestController
@RequestMapping("/payment")
public class PayementController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Long doPayment(@RequestBody PaymentRequestDTO paymentDTO) {
        return paymentService.doPayment(paymentDTO);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable Long orderId) {
        PaymentResponse paymentResponse = paymentService.getPaymentDetailsByOrderId(orderId);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

}
