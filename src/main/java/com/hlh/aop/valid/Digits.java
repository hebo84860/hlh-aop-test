package com.hlh.aop.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Digits {
	
	int min();

	int max();

	String message() default "超出输入值范围";

}
