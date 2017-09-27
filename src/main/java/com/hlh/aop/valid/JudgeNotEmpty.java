package com.hlh.aop.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
* 校验业务参数
* @author  zhangzongshuang 
* @date 2017年5月16日 下午4:28:31
* @version V1.0   
*/
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ ElementType.TYPE,ElementType.FIELD,ElementType.METHOD })
public @interface JudgeNotEmpty {
	String message() default "字符串不能为空";
}

