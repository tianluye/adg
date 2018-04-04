package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tian.lue
 */
public class StartSpringContainer {

    private static final String PACKAGE_PATH = "com.adg.spring";

    public static void main(String[] args) {
        // 启动 Spring容器，首先去加载包下的 META-INF/service下的文件
        Set<Class<?>> classSet = ServletContainerTools.loadServletContainerInitializerImplClasses();

        if (classSet.size() <= 0) {
            System.err.println("ServletContainerInitializer接口没有实现类。");
            return;
        }

        ServletContext servletContext = new ServletContext();

        // 遍历执行上面读取到的实现类的 onStartup方法
        for (Class<?> implClass : classSet) {
            // 检测是否是 ServletContainerInitializer接口的实现类
            if (!ServletContainerInitializer.class.isAssignableFrom(implClass)) {
                System.err.println(implClass.getName() + " 不是 ServletContainerInitializer接口的实现类。");
                continue;
            }
            // 注入实现类方法 onStartup的参数
            HandlesTypes hz = implClass.getAnnotation(HandlesTypes.class);
            if (null == hz) {
                System.err.println(implClass.getName() + " 没有 HandlesTypes注解，无法为 onStartup提供参数。");
                continue;
            }
            // 读取 HandlesTypes注解上的类
            Class<?>[] initializer = hz.value();
            // 根据包路径，获取其下所有的 class
            Set<Class<?>> classes = ServletContainerTools.getClasses(PACKAGE_PATH);
            // 遍历获取到每个及其子类的所有实现类
            Set<Class<?>> implClassSets = new HashSet<Class<?>>();
            for (Class<?> initClass : initializer) {
                Set<Class<?>> implClassSet = ServletContainerTools.getChildOrImplClass(initClass, classes);
                implClassSets.addAll(implClassSet);
            }
            // TODO： implClassSets进行排序
            try {
                Method method = implClass.getMethod("onStartup", Set.class, ServletContext.class);
                method.invoke(implClass.newInstance(), implClassSets, servletContext);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
