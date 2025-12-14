package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final WebClient.Builder webClientBuilder;

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    // 🔥 DEMO: Comunicación entre microservicios
    @GetMapping("/{id}/details")
    public Map<String, Object> getOrderDetails(@PathVariable Long id) {

        Order order = orderService.findById(id);

        Object user = webClientBuilder.build()
                .get()
                .uri("http://users-service/users/" + order.getUserId())
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        Object vehicle = webClientBuilder.build()
                .get()
                .uri("http://vehicles-service/vehicles/" + order.getVehicleId())
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return Map.of(
                "order", order,
                "user", user,
                "vehicle", vehicle
        );
    }
}
