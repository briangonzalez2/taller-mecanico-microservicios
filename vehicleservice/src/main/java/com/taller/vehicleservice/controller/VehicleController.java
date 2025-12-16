package com.taller.vehicleservice.controller;

import com.taller.vehicleservice.model.Vehicle;
import com.taller.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> byUser(@PathVariable Long userId) {
        return vehicleService.findByUser(userId);
    }
}
