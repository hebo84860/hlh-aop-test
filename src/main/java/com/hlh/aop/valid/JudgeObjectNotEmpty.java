package com.hlh.aop.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 * 校验业务对象
 * @author  zhangzongshuang 
 * @date 2017年5月16日 下午4:28:12
 * @version V1.0   
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ ElementType.TYPE,ElementType.FIELD,ElementType.METHOD })
public @interface JudgeObjectNotEmpty {
	public String businessType() default "业务对象校验";
	public String message() default "对象不能为空";
}
