package com.taller.catalogservice.service;

import com.taller.catalogservice.client.UserClient;
import com.taller.catalogservice.model.Product;
import com.taller.catalogservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final UserClient userClient;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Object getProductWithUser(Long productId, Long userId) {
        Product product = repository.findById(productId).orElseThrow();
        Object user = userClient.getUserById(userId);
        return new Object[]{product, user};
    }
}
