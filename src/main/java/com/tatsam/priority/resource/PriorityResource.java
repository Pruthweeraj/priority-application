package com.tatsam.priority.resource;

import com.tatsam.priority.service.PriorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriorityResource {
    private static final Logger logger = LoggerFactory.getLogger(PriorityResource.class);


    @Autowired
    PriorityService priorityService;

    @GetMapping("/priority")
    private ResponseEntity getAllPriorities() {
        logger.info("Processing getAllPriorities request.");
        return new ResponseEntity(priorityService.getAllPriorities(), HttpStatus.OK);
    }


}
