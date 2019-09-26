package com.ywy.jfinal.annotation;

import java.lang.annotation.*;

/**
 * 定义需要校验的dto
 * @author ve
 * @date 2019/9/26 14:15
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Valid {
    String message() default "";
}
