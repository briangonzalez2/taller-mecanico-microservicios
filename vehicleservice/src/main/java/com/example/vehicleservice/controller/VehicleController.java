package com.example.vehicleservice.controller;
import com.example.vehicleservice.model.Vehicle;
import com.example.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService service;

    @GetMapping
    public List<Vehicle> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> getByUser(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
