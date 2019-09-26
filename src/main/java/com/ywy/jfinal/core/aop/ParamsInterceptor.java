package com.ywy.jfinal.core.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.ywy.jfinal.annotation.NotBlank;
import com.ywy.jfinal.annotation.Valid;
import com.ywy.jfinal.exception.BusErrorCode;
import com.ywy.jfinal.exception.BusException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;

/**
 * 参数检验拦截器
 * @author ve
 * @data 2019/8/13 18:24
 */
public class ParamsInterceptor implements Interceptor {

    /**
     * 校验当前参数值是否满足注解规则
     * @param annotation
     * @param value
     * @return
     */
    boolean check(Annotation annotation, Object value) {




        if (NotBlank.class.equals(annotation.annotationType())) {
            return value != null && value.toString().length() > 0;
        }



        return true;
    }

    @Override
    public void intercept(Invocation inv) {
        long begin = System.currentTimeMillis();
        if (inv.isActionInvocation()) {
            Set<String> error = new HashSet<>();
            Controller controller = inv.getController();
            // 找到所有参数
            Parameter[] parameters = inv.getMethod().getParameters();
            for (int i = 0; i < parameters.length; i++) {
                // 检验方法入参里面的校验注解
                for (Annotation methodAnnotation : parameters[i].getAnnotations()) {
                    if (Valid.class.equals(methodAnnotation.annotationType())) {
                        // 检验方法入参DTO对象里面的校验注解
                        Class clazz = parameters[i].getType();
                        for (Field declaredField : clazz.getDeclaredFields()) {
                            for (Annotation annotation : declaredField.getAnnotations()) {
                                if (annotation.annotationType().isAnnotationPresent(Valid.class)) {
                                    if (!check(annotation, controller.get(declaredField.getName()))) {
                                        error.add(declaredField.getName());
                                    }
                                }
                            }
                        }
                    } else if (methodAnnotation.annotationType().isAnnotationPresent(Valid.class)) {
                        if (!check(methodAnnotation, controller.get(parameters[i].getName()))) {
                            error.add(parameters[i].getName());
                        }
                    }
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("校验耗时:" + (end - begin) + "ms");
            if (error.size() > 0) {
                throw new BusException(BusErrorCode.CODE_400, JsonKit.toJson(error));
            }
        }

        inv.invoke();
    }
}
