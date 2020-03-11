package com.itheima.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: maven_web
 * @description: 演示两个过滤器如何工作
 * @author: JClearLove
 * @Date: 2020/03/11 08:14
 */
//@WebFilter(filterName = "TestFilter", urlPatterns = {"/index.jsp","/hello.html"})
public class HowTwoFiltersWorks implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("HowTwoFiltersWorks执行前！！！");
        chain.doFilter(request, response);
        System.out.println("HowTwoFiltersWorks执行后！！！");

    }

    @Override
    public void destroy() {

    }
}

