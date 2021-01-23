package com.tatsam.priority.dao;

import com.tatsam.priority.model.PriorityVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityDao extends JpaRepository<PriorityVO, Long> {

    PriorityVO findByValue(String value);
}
