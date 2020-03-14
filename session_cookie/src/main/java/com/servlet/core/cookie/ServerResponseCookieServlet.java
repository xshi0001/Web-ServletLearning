package com.servlet.core.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 *   cookie 快速入门
 * @Author: JClearLove
 * @Date: 2020/03/13 09:40
 */
@WebServlet("/ServerResponseCookieServlet")
public class ServerResponseCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie = new Cookie("msg", "hello");

        //设置cookie的存活时间,正数持久化到本地文件，负数为默认值，0，是清空cookie
        cookie.setMaxAge(30);

        //设置cookie的获取范围。默认情况下，设置当前的虚拟目录  如果要共享，则可以将path设置为"/"
        cookie.setPath("/");

        //发送cookie
        response.addCookie(cookie);






    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
