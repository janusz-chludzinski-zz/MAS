package com.mas.project.mas.Service;

import com.mas.project.mas.Beans.OrderDTO;
import com.mas.project.mas.ENUM.Status;
import com.mas.project.mas.Entity.*;
import com.mas.project.mas.Entity.Service;
import com.mas.project.mas.Repository.MechanicRepository;
import com.mas.project.mas.Repository.OrderRepository;
import com.mas.project.mas.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Janusz on 07.06.2017.
 */
@org.springframework.stereotype.Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MechanicRepository mechanicRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Order findByOrderNumber(Integer orderNumber) {
        return orderRepository.findOne(orderNumber);
    }

    @Override
    @Transactional
    public Order saveOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order = buildOrder(orderDTO, order);

        order = orderRepository.save(order);
        order.setServices(getServicesForOrder(orderDTO));

        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public Order setOrderStatus(Order order, Status status) {
        return null;
    }

    private Order buildOrder(OrderDTO orderDTO, Order order){

        order.setCar(buildCar(orderDTO));
        order.setClient(buildClient(orderDTO));
        order.setMechanic(getMechanicByEmail(orderDTO));
        order.setTotalCost(calculateTotalCost(order, orderDTO));
        order.setOrderNumber(generateOrderNumber(order));
        order.setRegistrationDate(new Date());
        order.setStatus(Status.REGISTERED);

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

    private Set<Service> getServicesForOrder(OrderDTO orderDTO){
        List<String> servicesNames = orderDTO.getServiceList();
        Set<Service> services = new HashSet<>();

        for(String serviceName : servicesNames){
            services.add(serviceRepository.findByName(serviceName));
        }


        return services;
    }

    private BigDecimal calculateTotalCost(Order order, OrderDTO orderDTO){
        List<String> services = orderDTO.getServiceList();
        BigDecimal result = new BigDecimal(0);
        Service service;

        for(String serviceName : services){
            service = serviceRepository.findByName(serviceName);
            result = result.add(service.getCost());
        }

        return result;
    }

    private String generateOrderNumber(Order order){
        StringBuilder sb = new StringBuilder();
        sb.append(dateToStringFormatYYYYMMDD());
        sb.append("_");
        sb.append(generateRandomNumber());

        return sb.toString();
    }

    private String dateToStringFormatYYYYMMDD(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String date = sdf.format(new Date());
        String[] dateElements = date.split("/");
        StringBuilder sb = new StringBuilder();

        for(String s : dateElements){
            sb.append(s);
        }

        return sb.toString();
    }

    private int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt((99999 - 10000) + 1) + 10000;
    }

    public Order findOne(Integer id){
        return orderRepository.findOne(id);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

}
