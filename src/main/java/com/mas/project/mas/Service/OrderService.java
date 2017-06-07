package com.mas.project.mas.Service;

import com.mas.project.mas.ENUM.Status;
import com.mas.project.mas.Entity.Order;

/**
 * Created by Janusz on 07.06.2017.
 */
public interface OrderService {
    Order findByOrderNumber(Long orderNumber);
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    Order setOrderStatus(Order order, Status status);
}
