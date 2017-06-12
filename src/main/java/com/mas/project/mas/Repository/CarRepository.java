package com.mas.project.mas.Repository;

import com.mas.project.mas.Entity.Car;
import com.mas.project.mas.Entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Janusz on 12.06.2017.
 */
public interface CarRepository extends JpaRepository<Mechanic, Long> {
    Car findByOrderId(int orderId);
}
