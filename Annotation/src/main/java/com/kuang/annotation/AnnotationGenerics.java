package com.kuang.annotation;

import scala.xml.PrettyPrinter;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
//用注解获取泛型
public class AnnotationGenerics {

    public void Test01(Map<String, Integer> map, List<Integer> list){
        System.out.println(map);
    }

    public Map<String, User> Test02(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method01 = AnnotationGenerics.class.getMethod("Test01",Map.class, List.class);
        for (Type genericParameterType : method01.getGenericParameterTypes()) {
            System.out.println(genericParameterType);

            for (Type actualTypeArgument : ((ParameterizedType) genericParameterType).getActualTypeArguments()) {
                System.out.println(actualTypeArgument);
            }
        }


        System.out.println("========");
//以下是为了获取返回类型中的泛型
        Method method02 = AnnotationGenerics.class.getMethod("Test02",null);
        System.out.println(method02.getGenericReturnType());
        for (Type actualTypeArgument : ((ParameterizedType) method02.getGenericReturnType()).getActualTypeArguments()) {
            System.out.println(actualTypeArgument);
        }

        System.out.println(Arrays.toString(method02.getGenericExceptionTypes()));

    }
}

