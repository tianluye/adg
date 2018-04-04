package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

/**
 * @author tian.lue
 */
public class AbstractAnnotationConfigDispatcherServletInitializer extends AbstractContextLoaderInitializer {

    @Override
    protected void registerServletContext(ServletContext servletContext) {
        System.out.println("******");
    }

    public void onStartup(ServletContext servletContext) {
        super.onStartup(servletContext);
    }

}
