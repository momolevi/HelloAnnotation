package com.kuang.annotation;

public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException {
        A a = new A();
        System.out.println(A.m);

//classLoader获取系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
//        获取系统父类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
//        获取根加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

//当前类是用什么类加载器加载的
        System.out.println(Class.forName("com.kuang.annotation.Test03").getClassLoader());

//双亲委派机制  获取java能够加载的路径
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