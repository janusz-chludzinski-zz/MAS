package com.mas.project.mas.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "Clients")
public class Client extends User {

    private Long clientNumber;
}
