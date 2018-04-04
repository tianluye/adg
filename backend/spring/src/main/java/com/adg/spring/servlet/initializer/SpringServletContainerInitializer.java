package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author tian.lue
 */
@HandlesTypes({WebApplicationInitializer.class})
public class SpringServletContainerInitializer implements ServletContainerInitializer {

    public SpringServletContainerInitializer() {

    }

    @Override
    public void onStartup(Set<Class<?>> initializer, ServletContext servletContext) {
        System.out.println("执行了 SpringServletContainerInitializer的 onStartup方法");
        LinkedList initializerInstance = new LinkedList();
        for (Class<?> clazz : initializer) {
            // 这里不需要在判断是否是其实现类，在传递之前就已经判断过了
            try {
                initializerInstance.add(clazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 进行排序，是实现了 Comparable接口
        Collections.sort(initializerInstance);
        Iterator iterator = initializerInstance.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            try {
                // 反射执行上面注解的值的实现类的 onStartup方法
                Method method = object.getClass().getMethod("onStartup", ServletContext.class);
                method.invoke(object, servletContext);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
