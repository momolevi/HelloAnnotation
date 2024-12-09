package com.kuang.annotation;

public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException {
        A a = new A();
        System.out.println(A.m);


        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
//        ClassLoader classLoader3 = Class.forName("com.kuang,annotation.Test03").getClassLoader();
//        System.out.println(classLoader3);
//双亲委派机制
        System.out.println(System.getProperty("java.class.path"));
    }


}

class A{
    static {
        System.out.println("静态代码块加载中");
        int m= 300;
    }

    static  int m = 100;
    public A() {
        System.out.println("A的构造器启动中");
    }
}