package com.itheima.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import static javax.servlet.DispatcherType.ERROR;

/**
 * @program: maven_web
 * @description: 404页面
 * @author: JClearLove
 * @Date: 2020/03/11 09:21
 */

@WebFilter(filterName="ErrorFilter",urlPatterns = "/error.jsp",dispatcherTypes = {ERROR})
public class ErrorPageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("404页面捕捉");

        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}

