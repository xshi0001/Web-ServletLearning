package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 敏感词汇过滤器
 * @Author: JClearLove
 * @Date: 2020/03/19 09:00
 */
@WebFilter(filterName = "sensitiveWordsFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "words", value = "笨蛋;坏蛋"),
        @WebInitParam(name = "charset", value = "UTF-8")})
public class SensitiveWordsFilter implements Filter {

    private FilterConfig config;


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 获取敏感词汇集合
        String inNormalWords = config.getInitParameter("words");
        String[] strArray = inNormalWords.split(";");
        //1.创建代理对象，增强getParameter方法

        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if ("getParameter".equals(method.getName())) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : strArray) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }

                //判断方法名是否是 getParameterMap

                //判断方法名是否是 getParameterValue

                return method.invoke(req, args);
            }
        });

        //2.放行
        chain.doFilter(proxyReq, resp);
    }


    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void destroy() {
    }

}
