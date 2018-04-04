package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

/**
 * @author tian.lue
 */
public class DispatcherServletInitializer extends AbstractContextInitializer {

    @Override
    protected void registerServletContext(ServletContext servletContext) {
        System.out.println("执行 DispatcherServletInitializer.registerServletContext()");
    }

    public void onStartup(ServletContext servletContext) {
        super.onStartup(servletContext);
    }

    @Override
    protected int getPriorityOrder() {
        return 0;
    }
}
