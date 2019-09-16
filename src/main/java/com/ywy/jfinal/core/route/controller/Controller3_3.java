package com.ywy.jfinal.core.route.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.ywy.jfinal.dto.TestDTO;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_3 extends Controller {

    // http://localhost/controller33?str=fff&test1.id=ffff&id=ffff
    public void index(
            @Para("str") String str,
            @Para("test1") TestDTO test1,
            @Para("") TestDTO test2) {
        renderText("此方法是一个action");
    }

}
