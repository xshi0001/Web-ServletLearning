package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: servlettotals
 * @description: 登陆Servlet
 * @author: JClearLove
 * @Date: 2020/03/11 10:49
 */
@WebServlet(urlPatterns = "/servlet/loginVerificationByFilterServlet")
public class LoginVerificationByFilterServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public LoginVerificationByFilterServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            // 登陆成功，跳转成功界面
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            // 重定向
            resp.sendRedirect(req.getContextPath() + "/sucess.jsp");
        } else {
            //登陆失败，错误界面
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }


    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        // Put your code here
    }

}
