package com.PaymentService.PaymentServiceDemo.Serviece;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PaymentService.PaymentServiceDemo.DTO.PaymentRequestDTO;
import com.PaymentService.PaymentServiceDemo.DTO.PaymentResponse;
import com.PaymentService.PaymentServiceDemo.Entity.TransactionDetials;
import com.PaymentService.PaymentServiceDemo.Repository.TransactionRepository;

@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private TransactionRepository paymentRepository;

    @Override
    public Long doPayment(PaymentRequestDTO paymentDTO) {
        TransactionDetials transaction = TransactionDetials.builder()
                .payamentDate(Instant.now())
                .paymentMode(paymentDTO.getPaymentMethod())
                .paymentStatus("Success")
                .amount(paymentDTO.getAmount())
                .referenceNumber(paymentDTO.getRefrenceNumber())
                .orderId(paymentDTO.getOrderId())
                .build();
        paymentRepository.save(transaction);
        return transaction.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {
        TransactionDetials transaction = paymentRepository.findByOrderId(orderId);
        PaymentResponse tr = PaymentResponse.builder()
                .paymentAmount(transaction.getAmount())
                .paymentStatus(transaction.getPaymentStatus())
                .paymentMethod(transaction.getPaymentMode())
                .paymentDate(transaction.getPayamentDate())
                .orderId(transaction.getOrderId())
                .build();
        return tr;
    }

}
