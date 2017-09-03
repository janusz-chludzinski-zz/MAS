package com.mas.project.mas.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "MECHANICS")
@AttributeOverrides({
        @AttributeOverride(name = "firstName", column=@Column(name = "FIRST_NAME")),
        @AttributeOverride(name = "lastName", column=@Column(name = "LAST_NAME")),
        @AttributeOverride(name = "email", column=@Column(name = "EMAIL")),
        @AttributeOverride(name = "phone", column=@Column(name = "PHONE"))
})
public class Mechanic extends Person {

    @Column(name = "SALARY")
    private String salary;

    @OneToMany(targetEntity = Order.class, mappedBy = "mechanic")
    private List<Order> orders;

}
