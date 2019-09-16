package com.ywy.jfinal.core.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class AdminInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("admin interceptor");
        invocation.invoke();
    }
}
