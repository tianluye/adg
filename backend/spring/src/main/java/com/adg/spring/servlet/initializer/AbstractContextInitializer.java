package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

import java.util.Comparator;

/**
 * @author tian.lue
 */
public abstract class AbstractContextInitializer
        implements WebApplicationInitializer, Comparable {

    public AbstractContextInitializer() {
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        this.registerServletContext(servletContext);
    }

    protected abstract void registerServletContext(ServletContext servletContext);

    @Override
    public int compareTo(Object o) {
        return this.getOrder() - ((WebApplicationInitializer) o).getOrder();
    }

    @Override
    public int getOrder() {
        return this.getPriorityOrder();
    }

    protected abstract int getPriorityOrder();

}
