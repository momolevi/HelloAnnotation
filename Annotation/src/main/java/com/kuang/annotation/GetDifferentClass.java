package com.kuang.annotation;

import org.junit.Test;
import scala.tools.nsc.transform.patmat.Interface;

import java.lang.annotation.ElementType;

public class GetDifferentClass {


    public static void main(String[] args) throws ClassNotFoundException {
//       通过类名获得
        Class<?> c1 = Class.forName("com.kuang.annotation.Teacher");
        System.out.println(c1);
//       通过类获得
        Class c2 = new Person().getClass();
        System.out.println(c2);
//
        Class c3 = Teacher.class.getSuperclass();
        System.out.println(c3);

//        所有类型的class类型
        Class c4 = String.class;
        Class c5 = Interface.class;
        Class c6 = int[].class;
        Class c7 = String[][].class;
        Class c8 = void.class;
        Class c9 = Class.class;
        Class c10 = ElementType.class;
        Class c11 = Override.class;


        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
        System.out.println(c11);
    }
}

class Teacher extends Person{
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class Student extends Person{
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class Person{
    String name;
    int id;

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
