package com.ywy.jfinal.annotation;

import java.lang.annotation.*;

/**
 * email校验
 * @author ve
 * @date 2019/9/26 11:32
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Valid
public @interface Email {
    String message() default "邮箱格式不正确";
}
