package com.kuang.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeConsumption {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }


    public static void test01(){
        long starttime = System.currentTimeMillis();

        User user1 = new User();
        for (int i = 0; i < 10000000; i++) {
            user1.getName();
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + "毫秒");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long starttime = System.currentTimeMillis();

        User user2 = new User();
        for (int i = 0; i < 10000000; i++) {
            Method method = user2.getClass().getDeclaredMethod("getName");
            method.invoke(user2);
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + "毫秒");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long starttime = System.currentTimeMillis();

        User user3 = new User();
        for (int i = 0; i < 10000000; i++) {
            Method method = user3.getClass().getDeclaredMethod("getName");
            method.setAccessible(true);
            method.invoke(user3);
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + "毫秒");
    }
}
