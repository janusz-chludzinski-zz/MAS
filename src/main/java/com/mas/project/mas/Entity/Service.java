package com.mas.project.mas.Entity;

import javax.persistence.*;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "SERVICES")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COST")
    private double cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
