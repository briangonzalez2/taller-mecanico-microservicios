package com.taller.vehicleservice.service;

import com.taller.vehicleservice.model.Vehicle;
import com.taller.vehicleservice.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findByUser(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }
}
