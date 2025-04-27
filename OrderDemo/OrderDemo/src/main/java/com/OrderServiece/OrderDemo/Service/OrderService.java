package com.OrderServiece.OrderDemo.Service;

import com.OrderServiece.OrderDemo.DTO.CreateOrderDTO;
import com.OrderServiece.OrderDemo.DTO.OrderResponseDTO;

public interface OrderService {
    Long createOrder(CreateOrderDTO createOrderDTO);

    OrderResponseDTO getOrders(Long id);

}