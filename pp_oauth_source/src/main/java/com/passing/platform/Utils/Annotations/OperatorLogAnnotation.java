package com.passing.platform.Utils.Annotations;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperatorLogAnnotation {
    String detail() default "";
    int level()default 0;

}
