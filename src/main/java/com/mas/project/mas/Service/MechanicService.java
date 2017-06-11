package com.mas.project.mas.Service;

import com.mas.project.mas.Entity.Mechanic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janusz on 11.06.2017.
 */
public interface MechanicService {
    List<Mechanic> findAllMechanics();
}
