package com.ywy.jfinal.core.route.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.ywy.jfinal.annotation.NotBlank;
import com.ywy.jfinal.annotation.Valid;
import com.ywy.jfinal.dto.AnnotationTestDTO;
import com.ywy.jfinal.dto.TestDTO;
import com.ywy.jfinal.dto.UserCreateDTO;
import com.ywy.jfinal.dto.UserRemoveDTO;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_3 extends Controller {

    // http://localhost/controller33?str=fff&test1.id=ffff&id=ffff
    public void index(@Para("str") String str,
                      @Para("test1") TestDTO test1,
                      @Para("") TestDTO test2) {
        renderText("此方法是一个action");
    }

    //@Para("") String bb // 使用Para映射参数不能传入空串""
    public void test2(@NotBlank(message = "校验不通过") @Para("aa1") String aa,
                      @NotBlank String cc,
                      @Valid UserCreateDTO userCreateDTO,
                      @Valid @Para("tttaa") UserCreateDTO tttt,
                      @Valid @Para("") UserRemoveDTO userRemoveDTO) {
        renderText("此方法是一个action");
    }

    public void test3(@Valid AnnotationTestDTO aaa) {
        renderText("此方法是一个action");
    }

}
