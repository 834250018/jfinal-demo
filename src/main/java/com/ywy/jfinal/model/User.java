package com.ywy.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class User extends Model<User> {

    private String id;
    private String name;
    private String realName;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public User() {
    }

    public User(String id, String name, String realName) {
        this.id = id;
        this.name = name;
        this.realName = realName;
    }
}
