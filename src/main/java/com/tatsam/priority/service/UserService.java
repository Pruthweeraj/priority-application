package com.tatsam.priority.service;

import com.tatsam.priority.domain.UserRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    void saveUserPriority(UserRequest userRequest);
}
