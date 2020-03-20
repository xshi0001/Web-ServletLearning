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
        // web-->服务器，resquest过滤，对resquest的对象进行增强,土匪第一次见
        System.out.println("HowTwoFiltersWorks执行前！！！");
        // 经过过滤器之后，放行，到外婆家
        chain.doFilter(request, response);
        // 服务器-->web，response过滤，对response的对象进行增强，土匪第二次见
        System.out.println("HowTwoFiltersWorks执行后！！！");

    }

    @Override
    public void destroy() {

    }
}

