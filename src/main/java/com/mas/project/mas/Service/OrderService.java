package com.mas.project.mas.Service;

import com.mas.project.mas.Beans.OrderDTO;
import com.mas.project.mas.ENUM.Status;
import com.mas.project.mas.Entity.Order;

import java.util.List;

/**
 * Created by Janusz on 07.06.2017.
 */
public interface OrderService {
    Order saveOrder(OrderDTO order);
    Order findOneOrder(Integer id);
    List<Order> findAllOrders();
}
