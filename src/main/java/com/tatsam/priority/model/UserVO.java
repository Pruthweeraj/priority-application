package com.tatsam.priority.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "user")
@IdClass(UserId.class)
public class UserVO {

    @Id
    @Column(name = "user_name")
    private String name;

    @Id
    @Column(name = "priority_id")
    private Long priorityId;

    @Column(name = "rating")
    private Integer rating;


    public UserVO() {
    }

    public UserVO(String name, Long priorityId, Integer rating) {
        this.name = name;
        this.priorityId = priorityId;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserVO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", priorityId=").append(priorityId);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
