package com.mas.project.mas.Repository;

import com.mas.project.mas.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Janusz on 12.06.2017.
 */
@Repository("serviceRepository")
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByName(String name);
}
