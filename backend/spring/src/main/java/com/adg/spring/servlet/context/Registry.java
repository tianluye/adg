package com.adg.spring.servlet.context;

/**
 * @author tian.lue
 */
public interface Registry {

    void register(Class... var1);

    void scan(String... var1);

}