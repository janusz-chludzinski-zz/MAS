package com.mas.project.mas.Repository;

import com.mas.project.mas.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Janusz on 07.06.2017.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
