# 注解和反射
## 元注解 meta-anontation
### target 
    声明@用在什么地方
### Retention
    @在什么地方有效
    source < class < Runtime
### Documented
    @是否生成注解在java中
### Inherited
    @子类是否可以继承父类的注解
    
## 自定义注解
### 自定义
```java
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

```

## 利用java的准动态语言


## 获得反射对象
### Class.forName Returns the Class object associated with the class or interface with the given string name.
```java
public class Test01 {

    @Test
    @MyAnnotation(name = "gigi")
    public void A() throws ClassNotFoundException {
        Class c1 = Class.forName("com.kuang.annotation.User");
        Class c2 = Class.forName("com.kuang.annotation.User");
        System.out.println(c1==c2);
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
```

### Class常用方法
搞清楚 有Declared 与没有 Declared区别
getFields()与getDeclaredFields()区别:
getFields()只能访问类中声明为公有的字段,私有的字段它无法访问，能访问从其它类继承来的公有方法. public
getDeclaredFields()能访问类中所有的字段,与public,private,protect无关，不能访问从其它类继承来的方法

getMethods()与getDeclaredMethods()区别:
getMethods()只能访问类中声明为公有的方法,能访问从其它类继承来的公有方法.
getDeclaredFields()能访问类中所有的字段,与public,private,protect无关,不能访问从其它类继承来的方法

getConstructors()与getDeclaredConstructors()区别:
getConstructors()只能访问类中声明为public的构造函数.
getDeclaredConstructors()能访问类中所有的构造函数,与public,private,protect无关

## 所有类型的class
```java
package com.kuang.annotation;

import org.junit.Test;
import scala.tools.nsc.transform.patmat.Interface;

import java.lang.annotation.ElementType;

public class Test02 {


    public static void main(String[] args) throws ClassNotFoundException {

//        所有类型的class类型
        Class c4 = String.class;
        Class c5 = Interface.class;
        Class c6 = int[].class;
        Class c7 = String[][].class;
        Class c8 = void.class;
        Class c9 = Class.class;
        Class c10 = ElementType.class;
        Class c11 = Override.class;
                    
    }
}

class com.kuang.annotation.Person
class java.lang.String
interface scala.tools.nsc.transform.patmat.Interface
class [I
class [[Ljava.lang.String;
void
class java.lang.Class
class java.lang.annotation.ElementType
interface java.lang.Override
```


加载 将静态文件读入方法区，并生成Class对象。然后把对象存放在java堆

链接 检查 java语法
    准备 static分配存储，设置默认值， 方法区中分配
    解析 常量也有赋值

初始化 <clinit>构造器执行，合并链接阶段的所有static代码+赋值动作
      父类如果没有初始化，先初始化父类。



### 
```java System.out.println(System.getProperty("java.class.path")); 
/Users/mac/IdeaProjects/Annotation/HelloAnnotation/Annotation/target/classes:
/Users/mac/.m2/repository/org/scala-lang/scala-compiler/2.12.12/scala-compiler-2.12.12.jar:
/Users/mac/.m2/repository/org/scala-lang/scala-library/2.12.12/scala-library-2.12.12.jar:
/Users/mac/.m2/repository/org/scala-lang/scala-reflect/2.12.12/scala-reflect-2.12.12.jar:
/Users/mac/.m2/repository/org/scala-lang/modules/scala-xml_2.12/1.0.6/scala-xml_2.12-1.0.6.jar:
/Users/mac/.m2/repository/junit/junit/4.13.1/junit-4.13.1.jar:
/Users/mac/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
```

## 获取运行时的完整结构
```java 
//wrong
        Constructor user2 = User.class.getConstructor(String.class, int.class, String.class);
        User u = (User)user2.newInstance("张三",21213,"1231231321312");
        Method method = u.getClass().getDeclaredMethod("setName",String.class);
        method.invoke(user2, "李四");
        System.out.println(user2.getName());

//currect
        Class c1 = Class.forName("com.kuang.annotation.User");
        Constructor constructor = c1.getConstructor(String.class, int.class, String.class);
        User u = (User)constructor.newInstance("张三",21213,"1231231321312");
        Method method = u.getClass().getDeclaredMethod("setName",String.class);
        method.invoke(u, "李四");
        System.out.println(u.getName());
    ```
    
## setAccessible(true) 启用和禁用安全检查
提高访问效率
```java 

    ```



