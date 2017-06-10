package com.mas.project.mas.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "MECHANICS")
public class Mechanic extends User {
    @Id
    private int id;

    @OneToMany(targetEntity = Order.class, mappedBy = "mechanic")
    private List<Order> orders;
    private Double salary;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
