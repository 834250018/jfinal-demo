package com.ywy.jfinal.core.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class MyInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("doSomething before method invoking");
        // 必须调用，才能将当前调用传递到后续interceptor与action
        invocation.invoke();

        System.out.println("doSomething after method invoking");
//        invocation.getController();
//        invocation.getActionKey();
//        invocation.getControllerKey();
//        invocation.getViewPath();
//        invocation.getTarget();
//        invocation.getMethod();
//        invocation.getMethodName();
//        invocation.getArgs();
//        invocation.getReturnValue();
//        invocation.isActionInvocation();
    }
}
