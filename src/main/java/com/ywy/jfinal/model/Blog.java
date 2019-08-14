package com.ywy.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Blog extends Model<Blog> {

    private String age;
    private String name;

    public Blog(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public Blog() {
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
