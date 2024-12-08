package com.kuang.annotation;

import org.junit.Test;
import scala.Int;

import java.lang.annotation.*;

public class Test01 {

    @Test
    @MyAnnotation(name = "gigi")
    public void A() throws ClassNotFoundException {
        Class c1 = Class.forName("com.kuang.annotation.User");
        Class c2 = Class.forName("com.kuang.annotation.User");
        Class c3 = User.class;
        System.out.println(c1==c3);
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }

    @Target(value = {ElementType.FIELD, ElementType.METHOD})
    @Retention(value = RetentionPolicy.RUNTIME)
    @interface MyAnnotation{
        String value() default "";
        int id() default -1;
        String name();

    }

}


class User{
    String name;
    Int id;
    String Telephone;

    public User() {
    }

    public User(String name, Int id, String telephone) {
        this.name = name;
        this.id = id;
        Telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Int getId() {
        return id;
    }

    public void setId(Int id) {
        this.id = id;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
}