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

