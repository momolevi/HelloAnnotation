package com.kuang.annotation;

import org.w3c.dom.Element;

import java.lang.annotation.*;
import java.lang.reflect.Field;

import static java.lang.Class.forName;

public class Final{

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       Class student = Class.forName("com.kuang.annotation.Student2");
       Annotation[] annotations = student.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }


        Test test= (Test) student.getAnnotation(Test.class);
        System.out.println(test.value());

       Field f = student.getDeclaredField("id");
        System.out.println(f.getAnnotation(field.class).name());
        System.out.println(f.getAnnotation(field.class).length());

        System.out.println("==========");
    }

}
@Test("db_table")
class Student2 {
    @field(length = 10, name = "id_id")
    private int id;
    @field(length = 20, name = "id_name")
    private String name;


    public Student2() {
    }

    public Student2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface field{
    int length();
    String name();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
    String value();
}