package com.itheima.servlet.listener.attritube;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @program: maven_tomcat
 * @description: 对servletContext属性值增加和删除事件监听
 * @author: JClearLove
 * @Date: 2020/03/10 08:49
 */
@WebListener
public class MySevletContextAttritubeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }
}

