package com.itheima.servlet.demo;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @program: maven_tomcat
 * @description: 在类上使用@WebServlet注解，进行配置
 * @author: JClearLove
 * @Date: 2020/03/09 21:34
 */
@WebServlet(urlPatterns = "/demo2")
public class ServletAnnotation implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("use servlet3  Annotation。。。");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

