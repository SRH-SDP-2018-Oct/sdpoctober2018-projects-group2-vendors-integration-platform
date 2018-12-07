package org.srh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface POJO {

	public String[] hidden() default "";

	public String[] hiddenParam() default "";

	public String[] hideInnerReferredData() default "";

}
