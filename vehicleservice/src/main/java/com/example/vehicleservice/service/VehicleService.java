package com.example.vehicleservice.service;
import com.example.vehicleservice.model.Vehicle;
import com.example.vehicleservice.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Vehicle> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
