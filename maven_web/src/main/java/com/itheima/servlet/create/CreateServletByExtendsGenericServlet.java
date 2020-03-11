package com.itheima.servlet.create;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @program: servlettotals
 * @description: 继承 GenericServlet 类,实现了 Servlet 接口 com.itheima.service 的方法
 *
 * GenericServlet 是一个抽象类，实现了 Servlet 接口，并且对其中的 init() 和 destroy() 和 com.itheima.service() 提供了默认实现。
 * 在 GenericServlet 中，主要完成了以下任务：
 *
 *  将 init() 中的 ServletConfig 赋给一个类级变量，可以由 getServletConfig 获得；
 *  为 Servlet 所有方法提供默认实现；
 *  可以直接调用 ServletConfig 中的方法；
 *
 * @author: JClearLove
 * @Date: 2020/03/10 12:34
 */
@WebServlet(urlPatterns = "/CreateServletByExtendsGenericServlet")
public class CreateServletByExtendsGenericServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("heihei");
    }
}

