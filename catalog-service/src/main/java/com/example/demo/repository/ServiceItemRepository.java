package com.example.demo.repository;

import com.example.demo.model.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
}