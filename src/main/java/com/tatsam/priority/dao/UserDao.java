package com.tatsam.priority.dao;

import com.tatsam.priority.model.UserId;
import com.tatsam.priority.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserVO, UserId> {

}
