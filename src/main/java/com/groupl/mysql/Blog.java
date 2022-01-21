package com.groupl.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity // This tells Hibernate to make a table out of this class
public class Blog extends SqlObj {
    private Integer userId;

    private String tags;

    @NotEmpty
    private String date;

    public Blog(String name, Integer userId, String tags, String date) {
        super.setName(name);
        this.userId = userId;
        this.tags = tags;
        this.date = date;
    }

    public Blog() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = Integer.parseInt(userId);
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

