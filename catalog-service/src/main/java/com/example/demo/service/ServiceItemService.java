package com.example.demo.service;
import com.example.demo.model.ServiceItem;
import com.example.demo.repository.ServiceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceItemService {

    private final ServiceItemRepository repository;

    public List<ServiceItem> findAll() {
        return repository.findAll();
    }

    public ServiceItem findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public ServiceItem save(ServiceItem item) {
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}