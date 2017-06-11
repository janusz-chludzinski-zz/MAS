package com.mas.project.mas.Service;

import com.mas.project.mas.Entity.Mechanic;
import com.mas.project.mas.Repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janusz on 11.06.2017.
 */
@Service("mechanicService")
public class MechanicServiceImpl implements MechanicService{

    @Autowired
    MechanicRepository mechanicRepository;

    @Override
    public List<Mechanic> findAllMechanics() {
        return mechanicRepository.findAll();
    }
}
