package com.ywy.jfinal.annotation;

import java.lang.annotation.*;

/**
 * 检验String属性是否为空
 * @author ve
 * @date 2019/9/26 11:32
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Valid
public @interface NotBlank {
    String message() default "";
}
