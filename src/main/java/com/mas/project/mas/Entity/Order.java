package com.mas.project.mas.Entity;

import javax.persistence.*;

import com.mas.project.mas.ENUM.Status;
import java.util.Date;
import java.util.List;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "TOTAL_COST")
    private Double totalCost;

    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mechanic")
    private Mechanic mechanic;

    @Column(name = "ORDER_NUMBER")
    private String orderNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Car car;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Client client;

    @OneToMany(targetEntity = Service.class, mappedBy = "order")
    private List<Service> services;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
