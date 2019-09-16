package com.ywy.jfinal.model;

import com.jfinal.plugin.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends Model<User> implements Serializable {

    private String id;
    private String name;
    private String realName;

    public static final User dao = new User().dao();
}
