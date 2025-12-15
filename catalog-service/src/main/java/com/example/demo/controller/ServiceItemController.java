package com.example.demo.controller;

import com.example.demo.model.ServiceItem;
import com.example.demo.service.ServiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceItemController {

    private final ServiceItemService service;

    @GetMapping
    public List<ServiceItem> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServiceItem getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ServiceItem create(@RequestBody ServiceItem item) {
        return service.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}