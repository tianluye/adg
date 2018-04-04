package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

/**
 * @author tian.lue
 */
public abstract class AbstractContextLoaderInitializer implements WebApplicationInitializer {

    public AbstractContextLoaderInitializer() {
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        this.registerServletContext(servletContext);
    }

    protected abstract void registerServletContext(ServletContext servletContext);

    protected void setOrder(Long order) {
    }

}
