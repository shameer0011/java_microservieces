package com.PaymentService.PaymentServiceDemo.Serviece;

import com.PaymentService.PaymentServiceDemo.DTO.PaymentRequestDTO;
import com.PaymentService.PaymentServiceDemo.DTO.PaymentResponse;

public interface PaymentService {

    Long doPayment(PaymentRequestDTO paymentDTO);

    PaymentResponse getPaymentDetailsByOrderId(Long orderId);

}
