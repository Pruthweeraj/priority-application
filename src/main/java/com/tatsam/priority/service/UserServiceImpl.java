package com.tatsam.priority.service;

import com.tatsam.priority.dao.PriorityDao;
import com.tatsam.priority.dao.UserDao;
import com.tatsam.priority.domain.Priority;
import com.tatsam.priority.domain.UserRequest;
import com.tatsam.priority.model.PriorityVO;
import com.tatsam.priority.model.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    PriorityDao priorityDao;

    @Autowired
    UserDao userDao;

    @Override
    public void saveUserPriority(UserRequest userRequest) {

        List<Priority> priorities = userRequest.getPriorities();


        if (!CollectionUtils.isEmpty(priorities)) {
            priorities.forEach(priorityRequest -> {

                UserVO userVO = new UserVO();
                userVO.setName(userRequest.getName());

                PriorityVO priorityVO = priorityDao.findByValue(priorityRequest.getName());

                if (null != priorityVO) {
                    userVO.setPriorityId(priorityVO.getId());
                    userVO.setRating(priorityRequest.getRating());

                    logger.debug("Saving user : {}", userVO);
                    try {
                        userDao.save(userVO);
                    } catch (Exception e) {
                        logger.info("Skipping the user save action as it's already saved..!!");
                        //TODO: we can skip/update the User in case same user is sending request again.(according to the business use case)
                    }
                } else {
                    //TODO: We can add validation and throw custom exception.
                    logger.info("Invalid Priority : {}, Skipping the entry!!", priorityRequest.getName());
                }
            });
        }

    }
}
