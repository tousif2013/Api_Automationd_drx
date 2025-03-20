package com.ddrx.Api.Automation.commons;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MockUpData {
    String type() default "";
}
