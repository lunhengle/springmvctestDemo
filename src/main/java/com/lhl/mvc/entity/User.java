package com.lhl.mvc.entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/3/24.
 */
public class User implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;

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
}
