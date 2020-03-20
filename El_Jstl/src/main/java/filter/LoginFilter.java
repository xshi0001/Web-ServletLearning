package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 登陆过滤
 * @Author: JClearLove
 * @Date: 2020/03/19 09:00
 */
@WebFilter(filterName = "loginFilter", urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "noLoginPaths", value = "login.jsp;/loginServlet;/js/;/fonts/;/css/;/checkCodeServlet"),
        @WebInitParam(name = "charset", value = "UTF-8")})
public class LoginFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1 获取当前请求的url,要操作url 在httpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        // 2 获取过滤参数
        String noLoginPaths = config.getInitParameter("noLoginPaths");
        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);
        if (noLoginPaths != null) {
            //检查是否为空
            String[] strArray = noLoginPaths.split(";");
            for (String s : strArray) {
                if (s == null || "".equals(s)) {
                    continue;
                }
                if (request.getRequestURI().contains(s)) {
                    // 如果包含参数中的URI则直接跳过过滤程序，放行
                    chain.doFilter(req, resp);
                    return;
                }
            }
        }

        // 检查session的用户名信息
        if (request.getSession().getAttribute("user") != null) {
            // 如果有用户名信息，放行
            chain.doFilter(req, resp);
        } else {
            // 如果没有，则跳转到重新登陆界面
            request.setAttribute("login_msg", "您尚未登录，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, resp);
        }

    }


    @Override
    public void destroy() {
    }
}
