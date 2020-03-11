package com.itheima.servlet;

import com.itheima.mapper.LoginMapper;
import com.itheima.pojo.Login;
import com.itheima.service.impl.LoginServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: servlettotals
 * @description:
 * @author: JClearLove
 * @Date: 2020/03/11 17:45
 */
@WebServlet(urlPatterns = "/servlet/loginVerificationByDataBaseServlet")
public class LoginVerificationByDataBaseServlet extends HttpServlet {
    private ApplicationContext context;

    /**
     * Constructor of the object.
     */
    public LoginVerificationByDataBaseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + "======================" + password);
        //2.获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        //3.创建User对象
        Login loginUser = new Login();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(loginUser.getUsername() + "==========");

        // 通过数据库查询 登陆信息
        LoginMapper loginMapper = context.getBean(LoginMapper.class);
        Login login = loginMapper.selectByNameAndPassword(loginUser);


        //5.判断loginer
        if (login == null) {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            System.out.println(login.toString());
            //登录成功
            //存储数据
            req.setAttribute("loginer", login);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req, resp);
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
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

}

