package com.mas.project.mas.Entity;

import org.hibernate.annotations.Cache;

import javax.persistence.*;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "REGISTRATION")
    private String registration;

    @Column(name = "ENGINE_TYPE")
    private String engineType;

    @Column(name = "PRODUCTION_YEAR")
    private int productionYear;

    @OneToOne(mappedBy = "car")
    @JoinColumn(name = "ORDER_ID")
    private Order order;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
