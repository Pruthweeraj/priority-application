package com.tatsam.priority.service;

import com.tatsam.priority.dao.PriorityDao;
import com.tatsam.priority.model.PriorityVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {
    private static final Logger logger = LoggerFactory.getLogger(PriorityServiceImpl.class);

    @Autowired
    PriorityDao priorityDao;

    @Override
    public List<PriorityVO> getAllPriorities() {
        logger.info("Processing getAllPriorities request");
        return priorityDao.findAll();
    }
}
