package com.ywy.jfinal.core.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.kit.StrKit;
import com.ywy.jfinal.annotation.NotBlank;
import com.ywy.jfinal.annotation.Valid;
import com.ywy.jfinal.exception.BusErrorCode;
import com.ywy.jfinal.exception.BusException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

/**
 * 参数检验拦截器
 * @author ve
 * @data 2019/8/13 18:24
 */
public class ParamsInterceptor implements Interceptor {

    /**
     * 校验当前参数值是否满足注解规则
     * @param annotation
     * @param paramName
     * @param controller
     * @return
     */
    void check(Annotation annotation, String paramName, Controller controller) {
        Object value = controller.get(paramName);

        if (NotBlank.class.equals(annotation.annotationType())) {
            if (value == null || value.toString().length() == 0) {
                throw new BusException(BusErrorCode.CODE_400, paramName + ((NotBlank) annotation).message());
            }
        }
    }

    /**
     * 检验DTO中的参数条件
     * jFinal框架没有迭代传参,所以迭代校验不做(即DTO属性包含其他DTO)
     *
     * @param clazz
     * @param paramName
     * @param controller
     */
    private void checkClass(Class clazz, String paramName, Controller controller) {
        // 遍历所有的私有属性
        for (Field declaredField : clazz.getDeclaredFields()) {
            // 遍历当前属性的所有注解
            for (Annotation annotation : declaredField.getAnnotations()) {
                // 拼接DTO参数名跟当前属性名,如userCreateDTO.username
                String childName = (StrKit.isBlank(paramName) ? "" : paramName + ".") + declaredField.getName();
                if (annotation.annotationType().isAnnotationPresent(Valid.class)) {
                    // 检验参数
                    check(annotation, childName, controller);
                }
            }
        }
    }

    @Override
    public void intercept(Invocation inv) {
        if (inv.isActionInvocation()) {
            Controller controller = inv.getController();
            // 遍历所有参数
            Parameter[] parameters = inv.getMethod().getParameters();
            for (int i = 0; i < parameters.length; i++) {
                // 遍历当前第i个参数所有注解
                for (Annotation methodAnnotation : parameters[i].getAnnotations()) {
                    // 比较 @Para注解的命名(value),有则使用@Para的名称,无则使用参数名
                    Para para = parameters[i].getAnnotation(Para.class);
                    String paramName = para == null ? parameters[i].getName() : para.value();
                    if (Valid.class.equals(methodAnnotation.annotationType())) {
                        // 检查DTO中的相关注解
                        checkClass(parameters[i].getType(), paramName, controller);
                    } else if (methodAnnotation.annotationType().isAnnotationPresent(Valid.class)) {
                        // 校验参数
                        check(methodAnnotation, paramName, controller);
                    }
                }
            }
        }
        inv.invoke();
    }
}
