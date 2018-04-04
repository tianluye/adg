package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

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
    }
}
