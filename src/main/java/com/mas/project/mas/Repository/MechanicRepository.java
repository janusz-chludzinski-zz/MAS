package com.mas.project.mas.Repository;

import com.mas.project.mas.Entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Janusz on 07.06.2017.
 */
@Repository("mechanicRepository")
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

}
