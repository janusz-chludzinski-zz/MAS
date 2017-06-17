package com.mas.project.mas.Repository;

import com.mas.project.mas.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Janusz on 07.06.2017.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select * from orders", nativeQuery = true)
    List<Order> findAllOrders();

    @Query(value = "SELECT * FROM ORDERS o " +
            "INNER JOIN ORDER_SERVICE os ON o.id = os.order_id " +
            "INNER JOIN SERVICES s ON s.id = os.service_id " +
            "WHERE o.id = :id", nativeQuery = true)
    Order findOneOrder(@Param("id")Integer id);
}
