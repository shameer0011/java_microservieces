package com.OrderServiece.OrderDemo.Service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.OrderServiece.OrderDemo.DTO.CreateOrderDTO;
import com.OrderServiece.OrderDemo.DTO.OrderResponseDTO;
import com.OrderServiece.OrderDemo.DTO.PaymentDTO;
import com.OrderServiece.OrderDemo.DTO.PaymentRequest;
import com.OrderServiece.OrderDemo.DTO.ProductDTO;
import com.OrderServiece.OrderDemo.Entity.Orders;
import com.OrderServiece.OrderDemo.Exception.CustomeException;
import com.OrderServiece.OrderDemo.External.Client.PaymentService;
import com.OrderServiece.OrderDemo.External.Client.ProductService;
import com.OrderServiece.OrderDemo.Repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Long createOrder(CreateOrderDTO createOrderDTO) {
        if (createOrderDTO.getProductID() == null) {
            throw new CustomeException("Product ID is required", "Product is needed", 500);
        }

        log.info("Processing order...", createOrderDTO, createOrderDTO.getQuantity());

        productService.updateProductQuantity(createOrderDTO.getProductID(), createOrderDTO.getQuantity());

        Orders order = new Orders();
        order.setQuantity(createOrderDTO.getQuantity());
        order.setStatus(createOrderDTO.getStatus());
        order.setPaymentMode(createOrderDTO.getPaymentMode());
        order.setProductID(createOrderDTO.getProductID());
        order.setAmount(createOrderDTO.getAmount());

        // ✅ Save order before using getId()
        Orders savedOrder = orderRepository.save(order);

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(savedOrder.getId()) // ✅ Now getId() is not null
                .paymentMethod(createOrderDTO.getPaymentMode())
                .amount(createOrderDTO.getAmount())
                .refrenceNumber("SBT00113")
                .build();

        String orderStatus;

        try {
            paymentService.doPayment(paymentRequest);
            orderStatus = "PLACED";
        } catch (Exception e) {
            log.error("Error while creating order", e);
            orderStatus = "FAILED";
        }

        savedOrder.setStatus(orderStatus);
        orderRepository.save(savedOrder);
        return savedOrder.getId();
    }

    @Override
    public OrderResponseDTO getOrders(Long id) {
        Orders orders = orderRepository.findById(id)
                .orElseThrow(() -> new CustomeException("Order id is not available here",
                        "BAD REQUEST", 500));
        ProductDTO productDto = restTemplate.getForObject(
                "http://ProductDemo/api/product/" + orders.getProductID(), ProductDTO.class);
        // fetch payment details using order id
        PaymentDTO payment = restTemplate.getForObject(
                "http://PaymentServiceDemo/payment/order/" + orders.getId(), PaymentDTO.class);
        OrderResponseDTO dto = OrderResponseDTO.builder()
                .orderId(orders.getId())
                .orderStatus(orders.getStatus())
                .amount(orders.getAmount())
                .orderDate(Instant.now())
                .productResponse(new OrderResponseDTO.ProductResponse(
                        productDto.getProductId(),
                        productDto.getPrice(),
                        productDto.getName(),
                        productDto.getQuantity()))
                .paymentResponse(payment != null ? new OrderResponseDTO.PaymentResponse(
                        payment.getPaymentId(),
                        payment.getPaymentStatus(),
                        payment.getPaymentMethod(),
                        payment.getPaymentAmount(),
                        Instant.now(), id) : null)

                .build();

        return dto;
    }

}
