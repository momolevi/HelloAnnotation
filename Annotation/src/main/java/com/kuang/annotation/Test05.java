package com.kuang.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        User user1 = new User("张三",21213,"1231231321312");
        System.out.println(user1.name);

////wrong
//        Constructor user2 = User.class.getConstructor(String.class, int.class, String.class);
//        User u = (User)user2.newInstance("张三",21213,"1231231321312");
//        Method method = u.getClass().getDeclaredMethod("setName",String.class);
//        method.invoke(user2, "李四");
//        System.out.println(user2.getName());

//currect
        Class c1 = Class.forName("com.kuang.annotation.User");
        Constructor constructor = c1.getConstructor(String.class, int.class, String.class);
        User u = (User)constructor.newInstance("张三",21213,"1231231321312");
        Method method = u.getClass().getDeclaredMethod("setName",String.class);
        method.invoke(u, "李四");
        System.out.println(u.getName());
    }

}
