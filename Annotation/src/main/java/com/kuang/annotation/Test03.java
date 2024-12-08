package com.kuang.annotation;

public class Test03 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
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