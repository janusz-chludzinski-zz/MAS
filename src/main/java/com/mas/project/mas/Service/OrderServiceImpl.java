package com.mas.project.mas.Service;

import com.mas.project.mas.ENUM.Status;
import com.mas.project.mas.Entity.Order;
import com.mas.project.mas.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janusz on 07.06.2017.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order findByOrderNumber(Long orderNumber) {
        return orderRepository.findOne(orderNumber);
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public Order setOrderStatus(Order order, Status status) {
        return null;
    }
}
