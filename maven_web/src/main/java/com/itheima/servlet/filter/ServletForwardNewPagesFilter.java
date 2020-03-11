package com.itheima.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: maven_web
 * @description: 转发 forward
 * @author: JClearLove
 * @Date: 2020/03/11 08:49
 */
@WebFilter(filterName = "servletFilter", urlPatterns = {"/index.jsp"}, initParams = {@WebInitParam(name = "name", value = "xc"),
        @WebInitParam(name = "like", value = "java")})
public class ServletForwardNewPagesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init------ServletForwardNewPagesFilter！！！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ServletForwardNewPagesFilter执行前！！！");
        HttpServletRequest req = (HttpServletRequest) request;

        //转发 性能更快一点
        req.getRequestDispatcher("main.jsp").forward(request, response);
        System.out.println("ServletForwardNewPagesFilter执行后！！！");


    }

    @Override
    public void destroy() {
        System.out.println("destroy------ServletForwardNewPagesFilter！！！");
    }
}

