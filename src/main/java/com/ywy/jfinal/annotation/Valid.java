package com.ywy.jfinal.annotation;

import java.lang.annotation.*;

/**
 * 指定需要校验属性的dto
 * @author ve
 * @date 2019/9/26 14:15
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Valid {
    String message() default "";
}
