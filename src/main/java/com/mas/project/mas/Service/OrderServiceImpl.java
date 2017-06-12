package com.mas.project.mas.Service;

import com.mas.project.mas.Beans.OrderDTO;
import com.mas.project.mas.ENUM.Status;
import com.mas.project.mas.Entity.*;
import com.mas.project.mas.Entity.Service;
import com.mas.project.mas.Repository.MechanicRepository;
import com.mas.project.mas.Repository.OrderRepository;
import com.mas.project.mas.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Janusz on 07.06.2017.
 */
@org.springframework.stereotype.Service("orderService")
public class OrderServiceImpl implements OrderService {

    Order order = new Order();

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MechanicRepository mechanicRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Order findByOrderNumber(Long orderNumber) {
        return orderRepository.findOne(orderNumber);
    }

    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        order = buildOrder(orderDTO);
        orderRepository.save(order);
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
        order.setServices(getServicesForOrder(orderDTO));
        order.setTotalCost(calculateTotalCost());
        order.setOrderNumber(generateOrderNumber());
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
        car.setOrder(order);

        return car;
    }

    private Client buildClient(OrderDTO orderDTO){
        Client client = new Client();
        client.setFirstName(orderDTO.getFirstName());
        client.setLastName(orderDTO.getLastName());
        client.setEmail(orderDTO.getEmail());
        client.setPhone(orderDTO.getPhone());
        client.setOrder(order);

        return client;
    }

    private List<Service> getServicesForOrder(OrderDTO orderDTO){
        List<String> servicesNames = orderDTO.getServiceList();
        List<Service> services = new ArrayList<>();

        for(String serviceName : servicesNames){
            services.add(serviceRepository.findByName(serviceName));
        }


        return services;
    }

    private double calculateTotalCost(){
        List<Service> services = order.getServices();
        double result = 0;

        for(Service service : services){
            result += service.getCost();
        }

        return result;
    }

    private String generateOrderNumber(){
        StringBuilder sb = new StringBuilder();
        sb.append(dateToStringFormatYYYYMMDD());
        sb.append("_");
        sb.append(order.getTotalCost());

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


}
