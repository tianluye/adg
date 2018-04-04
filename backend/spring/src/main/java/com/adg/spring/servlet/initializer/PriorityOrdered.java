package com.adg.spring.servlet.initializer;

/**
 * @author tian.lue
 */
public interface PriorityOrdered {

    int HIGHEST_PRECEDENCE = -2147483648;
    int LOWEST_PRECEDENCE = 2147483647;

    int getOrder();

}
