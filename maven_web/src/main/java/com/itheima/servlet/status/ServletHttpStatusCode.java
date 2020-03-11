package com.itheima.servlet.status;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;

/**
 * @program: servlettotals
 * @description: 把 407 错误代码发送到客户端浏览器，浏览器会显示 "Need authentication!!!" 消息。
 * @author: JClearLove
 * @Date: 2020/03/10 14:25
 */
@WebServlet(urlPatterns = "/showError")
public class ServletHttpStatusCode extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // 设置错误代码和原因
        response.sendError(407, "Need authentication!!!");
    }


    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

