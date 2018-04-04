package com.adg.spring.servlet.initializer;

import com.adg.spring.servlet.context.ServletContext;

import java.util.Set;

/**
 * Spring定义的 Servlet容器启动接口，其全类名会写在 META-INF/service下的文件里面（文件名称是其全类名）
 *
 * @author tian.lue
 */
public interface ServletContainerInitializer {

    void onStartup(Set<Class<?>> initializer, ServletContext servletContext);

}
