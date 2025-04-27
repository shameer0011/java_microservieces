package com.PaymentService.PaymentServiceDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PaymentService.PaymentServiceDemo.Entity.TransactionDetials;

public interface TransactionRepository extends JpaRepository<TransactionDetials, Long> {
    TransactionDetials findByOrderId(Long id);
}