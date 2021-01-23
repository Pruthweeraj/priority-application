package com.tatsam.priority.service;

import com.tatsam.priority.model.PriorityVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PriorityService {
    List<PriorityVO> getAllPriorities();
}
