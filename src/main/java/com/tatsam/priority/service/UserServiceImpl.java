package com.tatsam.priority.service;

import com.tatsam.priority.dao.PriorityDao;
import com.tatsam.priority.dao.UserDao;
import com.tatsam.priority.domain.Priority;
import com.tatsam.priority.domain.UserRequest;
import com.tatsam.priority.exception.PriorityException;
import com.tatsam.priority.model.PriorityVO;
import com.tatsam.priority.model.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    PriorityDao priorityDao;

    @Autowired
    UserDao userDao;

    @Override
    public void saveUserPriority(UserRequest userRequest) {

        // -- validating complete user request.
        validate(userRequest);

        List<Priority> priorities = userRequest.getPriorities();

        if (!CollectionUtils.isEmpty(priorities)) {
            priorities.forEach(priorityRequest -> {

                UserVO userVO = new UserVO();
                userVO.setName(userRequest.getName());

                PriorityVO priorityVO = priorityDao.findByValue(priorityRequest.getName());
                userVO.setPriorityId(priorityVO.getId());
                userVO.setRating(priorityRequest.getRating());

                logger.debug("Saving/Updating user : {}", userVO);
                userDao.save(userVO);
            });
        }

    }

    private void validate(UserRequest userRequest) {

        // -- validating if user is null/empty.
        if (!StringUtils.hasText(userRequest.getName())) {
            logger.info("name is null, Breaking Out..!!");
            throw new PriorityException("Name is missing", HttpStatus.BAD_REQUEST);
        }

        // -- validation if no Priority mention in the request.
        if (CollectionUtils.isEmpty(userRequest.getPriorities())) {
            logger.info("priority list is empty, Breaking Out..!!");
            throw new PriorityException("Priorities is missing", HttpStatus.BAD_REQUEST);
        }

        // -- Validation if the rating is not in between 1 to 5.
        userRequest.getPriorities().stream().map(Priority::getRating).forEach(rating -> {
            if (!((rating >= 1) && (rating <= 5))) {
                logger.info("rating is not in 1-5 range, Breaking Out..!!");
                throw new PriorityException("Satisfaction range should be in range 1 to 5", HttpStatus.BAD_REQUEST);
            }
        });

        // -- Validation if the priority is invalid.
        List<String> dbPriorities = priorityDao.findAll().stream().
                map(priorityVO -> priorityVO.getValue())
                .collect(Collectors.toList());

        userRequest.getPriorities().forEach(priority -> {
            if (!dbPriorities.contains(priority.getName())) {
                logger.info("priority value is not present in db, Breaking Out..!!");
                throw new PriorityException("Invalid Priority: " + priority.getName(), HttpStatus.BAD_REQUEST);
            }
        });

    }
}
