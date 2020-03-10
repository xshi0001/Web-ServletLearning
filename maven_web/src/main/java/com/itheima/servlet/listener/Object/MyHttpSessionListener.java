package com.itheima.servlet.listener.Object;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: maven_tomcat
 * @description: HttpSession Listener
 * @author: JClearLove
 * @Date: 2020/03/10 08:11
 */
@WebListener()
public class MyHttpSessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        System.out.println("http-sessionCreated");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("http-sessionDestroyed");

    }
}

