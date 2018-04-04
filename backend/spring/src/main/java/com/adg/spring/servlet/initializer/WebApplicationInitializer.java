package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

/**
 * @author tian.lue
 */
public interface WebApplicationInitializer extends PriorityOrdered {

    void onStartup(ServletContext servletContext);

}
