package com.itheima.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.logging.LogRecord;

/**
 * @program: servlettotals
 * @description: Servlet 过滤器可以动态地拦截请求和响应，以变换或使用包含在请求或响应中的信息。
 * @author: JClearLove
 * @Date: 2020/03/10 14:30
 */
//@WebFilter(filterName = "servletFilter", urlPatterns = {"/index.jsp", "/main.jsp"}, initParams = {@WebInitParam(name = "name", value = "xc"),
//        @WebInitParam(name = "like", value = "java")})
public class ServletRedirectNewPagesFilter implements Filter {

    /**
     * 初始化方法，web容器创建过滤器实例后将调用这个方法，这个方法可以读取web.xml文件中过滤参数
     * <p>
     * 死循环中....
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init------servletFilter！！！");

        // 得到过滤器的名字
        String filterName = config.getFilterName();
        // 得到在web.xml文件中配置的初始化参数
        String initParam1 = config.getInitParameter("name");
        String initParam2 = config.getInitParameter("like");
        // 返回过滤器的所有初始化参数的名字的枚举集合。
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }

    /**
     * 过滤器核心方法，当用户请求访问过滤器相关的URL时，web容器将先调用doFilter方法，
     * <p>
     * FilterChain参数可以调用chain.doFilter方法，将请求传给下一个过滤器（或者目标资源），或者利用转发、重定向将请求转发到其他资源
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        System.out.println("servletFilter执行前！！！");

        // 让目标资源执行，放行
//        chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //重定向
        resp.sendRedirect(req.getContextPath() + "/main.jsp");



        System.out.println("servletFilter执行后！！！");
    }

    @Override
    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
        System.out.println("----过滤器销毁----");
    }

}

