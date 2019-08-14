package com.ywy.jfinal.handle;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class MyHandler extends Handler {
    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleans) {
        System.out.println("myHandle");
    }
}
