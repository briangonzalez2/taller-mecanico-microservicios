package com.taller.orderservice.service;

import com.taller.orderservice.client.CatalogClient;
import com.taller.orderservice.client.UserClient;
import com.taller.orderservice.model.Order;
import com.taller.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final CatalogClient catalogClient;

    public Order createOrder(Order order) {
        userClient.getUserById(order.getUserId());
        catalogClient.getProductById(order.getProductId());
        return orderRepository.save(order);
    }
}
