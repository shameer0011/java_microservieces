package com.OrderServiece.OrderDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderServiece.OrderDemo.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
