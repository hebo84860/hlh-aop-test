package com.hlh.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Created by hebo on 2017-9-27.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamsValid {

    /**
     * 映射的方法
     * @return
     */
    String method() default "";
    /**
     * 支持的api版本
     * @return
     */
    String version() default "ALL";

}
