package com.tatsam.priority.resource;

import com.tatsam.priority.domain.UserRequest;
import com.tatsam.priority.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    UserService userService;

    @PostMapping("/user")
    private ResponseEntity saveUserPriority(@RequestBody UserRequest userRequest) {
        logger.info("Processing saveUserPriority request: {}", userRequest);
        userService.saveUserPriority(userRequest);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
