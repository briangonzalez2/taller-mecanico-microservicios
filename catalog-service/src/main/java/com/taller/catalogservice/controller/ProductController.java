package com.taller.catalogservice.controller;

import com.taller.catalogservice.model.Product;
import com.taller.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/{productId}/user/{userId}")
    public Object getProductWithUser(@PathVariable Long productId, @PathVariable Long userId) {
        return service.getProductWithUser(productId, userId);
    }
}

