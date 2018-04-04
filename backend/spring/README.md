# adg

Spring容器启动：

Spring定义了一个接口和一个文件：

```java
javax.servlet.ServletContainerInitializer
```

而文件名恰好是这个接口名，在 spring-web/META-INF/services下。



Spring读取这个文件，文件里面存放的是一些实现了上面定义的接口实现类的全类名。启动后，会去找到上面的这些实现类，并去执行他们实现的方法 onStartup。

```java
// onStartup方法
void onStartup(Set<Class<?>> var1, ServletContext var2) throws ServletException;
```



onStartup 方法的第一个参数是一个 Set集合，它的值来源于注解 @HandlesTypes

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlesTypes {
    Class<?>[] value();
}

// 实现类
@HandlesTypes({WebApplicationInitializer.class})
public class SpringServletContainerInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> var1, ServletContext var2) throws ServletException {
    }
}
```

Set集合的值就是注解 @HandlesTypes的 value()值的 Class类型数组在项目里定义实现类及其子类的实现类。

第二个参数就是容器的上下文了。



```java
Method method = implClass.getMethod("onStartup", Set.class, ServletContext.class);
method.invoke(implClass.newInstance(), implClassSets, servletContext);
```

反射执行文件里指定的接口实现类的 onStartup方法

