package com.servlet.core.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 1. 需求：
 * 1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 * <p>
 * 2. 分析：
 * 1. 可以采用Cookie来完成
 * 2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 1. 有：不是第一次访问
 * 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 2. 没有：是第一次访问
 * 1. 响应数据：您好，欢迎您首次访问
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * @Author: JClearLove
 * @Date: 2020/03/13 11:05
 */
@WebServlet("/CookieCaseServlet")
public class CookieCaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 遍历cookies，是否有该用户信息 lastName
                String name = cookie.getName();
                if ("lastname".equals(name)) {
                    //不是第一次访问，更新用户值、
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    System.out.println("编码前：" + str_date);
                    //URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + str_date);

                    cookie.setValue(str_date);
                    //设置cookie的存活时间 一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    //响应数据
                    //获取Cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    //URL解码：
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>");
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            //没有，第一次访问

            //设置Cookie的value
            //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前：" + str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + str_date);

            Cookie cookie = new Cookie("lastTime", str_date);
            //设置cookie的存活时间 一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");


        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

