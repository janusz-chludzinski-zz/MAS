package com.mas.project.mas.Service;

import com.mas.project.mas.Beans.OrderDTO;
import com.mas.project.mas.ENUM.Status;
import com.mas.project.mas.Entity.Car;
import com.mas.project.mas.Entity.Client;
import com.mas.project.mas.Entity.Mechanic;
import com.mas.project.mas.Entity.Order;
import com.mas.project.mas.Repository.MechanicRepository;
import com.mas.project.mas.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janusz on 07.06.2017.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    Order order = new Order();

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MechanicRepository mechanicRepository;

    @Override
    public Order findByOrderNumber(Long orderNumber) {
        return orderRepository.findOne(orderNumber);
    }

    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        order = buildOrder(orderDTO);

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

    private Order buildOrder(OrderDTO orderDTO){
        order.setCar(buildCar(orderDTO));
        order.setClient(buildClient(orderDTO));
        order.setMechanic(getMechanicByEmail(orderDTO));

        return order;
    }

    private Mechanic getMechanicByEmail(OrderDTO orderDTO){
        return mechanicRepository.findByEmail(orderDTO.getMechanic());
    }

    private Car buildCar(OrderDTO orderDTO){
        Car car = new Car();
        car.setBrand(orderDTO.getBrand());
        car.setModel(orderDTO.getModel());
        car.setRegistration(orderDTO.getRegistration());
        car.setEngineType(orderDTO.getEngineType());
        car.setProductionYear(Integer.parseInt(orderDTO.getProdYear()));

        return car;
    }

    private Client buildClient(OrderDTO orderDTO){
        Client client = new Client();
        client.setFirstName(orderDTO.getFirstName());
        client.setLastName(orderDTO.getLastName());
        client.setEmail(orderDTO.getEmail());
        client.setPhone(orderDTO.getPhone());

        return client;
    }
}
