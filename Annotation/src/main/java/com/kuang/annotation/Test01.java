package com.kuang.annotation;

import org.junit.Test;

import java.lang.annotation.*;

public class Test01 {

    @Test
    @MyAnnotation(name = "gigi")
    public void A(){
    }
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation{
        String value() default "";
        int id() default -1;
        String name();

    }

}


