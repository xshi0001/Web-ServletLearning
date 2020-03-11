package com.itheima.servlet.create;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: servlettotals
 * @description: HttpServlet 也是一个抽象类，它进一步继承并封装了 GenericServlet，使得使用更加简单方便，
 * 由于是扩展了 Http 的内容，所以还需要使用 HttpServletRequest 和 HttpServletResponse，
 * 这两个类分别是 ServletRequest 和 ServletResponse 的子类。
 * @author: JClearLove
 * @Date: 2020/03/10 12:37
 */
@WebServlet(urlPatterns = "/createServletByExtendsHttpServlet")
public class CreateServletByExtendsHttpServlet extends HttpServlet {

    private String message;


    @Override
    public void init() throws ServletException {
        // 执行必需的初始化
        this.message = "Hello World";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型
        resp.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ee");
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("销毁servlet实例");
    }

}

