package com.example.parking.Repository;

import com.example.parking.Entity.TimeAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeAndPriceRepository extends JpaRepository<TimeAndPrice, Long> {
}
