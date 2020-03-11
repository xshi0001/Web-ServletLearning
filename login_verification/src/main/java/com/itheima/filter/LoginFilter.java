package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * 设计Servlet，登陆、失败和成功页面，此时问题，当用户直接输入成功命令的url后，仍然能够成功
 *
 *
 * 设计设计过滤操作，查看当前页面是否已经成功登陆，如果没有，要跳转到登陆页面，登陆完之后才能继续操作
 *
 * 成功页面--》检查是否包含用户名信息，有-已经登陆，没-跳转登陆界面
 * 如果跳转到登陆页面，因登陆界面没有用户名信息，为filter-urlPatterns = "/*",此时filter会一直死循环到登陆url
 *
 * 因此需要判定当前的url是否包含login.jsp信息，则不过滤
 *
 * 当用户输入错误登陆账号或者密码的时候，没有跳转到失败界面，反而一直在登陆界面，因为又被filter拦截到登陆界面
 *
 * 还有错误ERROR页面等...
 *
 * 此时需要修改filter的config，避免过滤login.jso、fail.jsp、
 *
 *
 * @author xshi0
 */
@WebFilter(filterName = "loginInServlet", urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "noLoginPaths", value = "login.jsp;fail.jsp;LoginServlet"),
        @WebInitParam(name = "charset", value = "UTF-8")
})
public class LoginFilter implements Filter {

    private FilterConfig config;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();
        // 获取过滤参数
        String noLoginPaths = config.getInitParameter("noLoginPaths");
        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);

        if (noLoginPaths != null) {
            // 检查是否为空
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {

                if (strArray[i] == null || "".equals(strArray[i])) {
                    continue;
                }

                if (request.getRequestURI().contains(strArray[i])) {
                    // 如果包含参数中的URI则直接跳过过滤程序，放行
                    arg2.doFilter(arg0, arg1);
                    return;
                }
            }

        }
        // 检查session的用户名信息
        if (session.getAttribute("username") != null) {
            // 如果有用户名信息，放行
            arg2.doFilter(arg0, arg1);
        } else {
            // 如果没有，则跳转到重新登陆界面
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        config = arg0;
    }

}
