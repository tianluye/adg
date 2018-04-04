package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

/**
 * @author tian.lue
 */
public class ServletInitializerTest extends AbstractContextInitializer {

    @Override
    protected int getPriorityOrder() {
        return 1;
    }

    @Override
    protected void registerServletContext(ServletContext servletContext) {
        System.out.println("执行 ServletInitializerTest.registerServletContext()");
    }

    public void onStartup(ServletContext servletContext) {
        super.onStartup(servletContext);
    }

}
