package com.servlet.checkcodedemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/13 15:14
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取属性
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        // 首先验证验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        // 忽略大小写
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 验证码正确
            // 判断用户名和密码是否正确
            if ("admin".equals(username) && "admin".equals(password)) {
                //success login

                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath() + "/success.jsp");

            } else {
                // login fail
                session.setAttribute("lgoin_error", "用户名或者密码错误");
                // forward
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            //验证码不一致
            request.setAttribute("cc_error", "验证码错误，请重新输入");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
