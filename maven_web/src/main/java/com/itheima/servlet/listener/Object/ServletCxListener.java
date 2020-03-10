package com.itheima.servlet.listener.Object;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: maven_tomcat
 * @description: ServletContext 创建与销毁 定时器 全局信息
 * @author: JClearLove
 * @Date: 2020/03/10 07:54
 */
public class ServletCxListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String initParam = servletContextEvent.getServletContext().getInitParameter("initParam");
        System.out.println("contextInitialized :"+ initParam);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
    }
}

