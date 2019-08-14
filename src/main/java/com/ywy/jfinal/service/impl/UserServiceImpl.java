package com.ywy.jfinal.service.impl;

import com.ywy.jfinal.service.UserService;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class UserServiceImpl implements UserService {

    private String id;
    private String name;

    public UserServiceImpl() {
    }

    public UserServiceImpl(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
