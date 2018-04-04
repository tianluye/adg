package com.adg.spring.servlet.context;

import java.util.Set;

/**
 * @author tian.lue
 */
public abstract class Context implements Registry {

    private Set<Class<?>> beanSet;

    @Override
    public void register(Class... var1) {

    }

    @Override
    public void scan(String... var1) {

    }
}
