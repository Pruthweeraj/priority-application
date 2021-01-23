package com.tatsam.priority.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRequest {

    private Long id;
    private String name;
    private List<Priority> priorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Priority> getPriorities() {
        return priorities;
    }

    public void setPriorities(List<Priority> priorities) {
        this.priorities = priorities;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRequest{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", priorities=").append(priorities);
        sb.append('}');
        return sb.toString();
    }
}
