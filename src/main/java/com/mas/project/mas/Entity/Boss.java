package com.mas.project.mas.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Janusz on 07.06.2017.
 */
@Entity
@Table(name = "Boss")
public class Boss extends Person {

    private double bonus;
}
