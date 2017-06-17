package com.mas.project.mas.Entity;

import javax.persistence.*;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "Clients")
@AttributeOverrides({
        @AttributeOverride(name = "firstName", column=@Column(name = "FIRST_NAME")),
        @AttributeOverride(name = "lastName", column=@Column(name = "LAST_NAME")),
        @AttributeOverride(name = "email", column=@Column(name = "EMAIL")),
        @AttributeOverride(name = "phone", column=@Column(name = "PHONE"))
})
public class Client extends Person {

    @OneToOne(mappedBy = "client")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
