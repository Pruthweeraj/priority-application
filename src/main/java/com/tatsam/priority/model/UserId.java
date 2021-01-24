package com.tatsam.priority.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class UserId implements Serializable {

    private String name;
    private Long priorityId;

    public UserId() {
    }

    public UserId(String name, Long priorityId) {
        this.name = name;
        this.priorityId = priorityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return name.equals(userId.name) && priorityId.equals(userId.priorityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priorityId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserId{");
        sb.append("name='").append(name).append('\'');
        sb.append(", priorityId=").append(priorityId);
        sb.append('}');
        return sb.toString();
    }
}
