package com.itheima.servlet.listener.attritube;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @program: maven_tomcat
 * @description: 监听域对象中的属性的增加与删除的事件监听器
 * @author: JClearLove
 * @Date: 2020/03/10 08:25
 */

public class MyHttpSessionAttritubeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}

