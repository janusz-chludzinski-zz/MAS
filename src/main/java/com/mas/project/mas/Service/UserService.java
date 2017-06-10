package com.mas.project.mas.Service;

import com.mas.project.mas.Entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by Janusz on 07.06.2017.
 */
public interface UserService {
    User findUserByEmail(String email);
}
