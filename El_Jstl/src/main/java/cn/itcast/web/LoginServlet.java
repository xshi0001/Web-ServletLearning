package cn.itcast.web;

import cn.itcast.domain.Controller;
import cn.itcast.service.impl.ControllerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        // 验证码
        String verifycode = request.getParameter("verifycode");

        System.out.println(verifycode);


        // 首先验证验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("CHECKCODE_SERVER");
        //删除session中存储的验证码
        session.removeAttribute("CHECKCODE_SERVER");
        // 忽略大小写
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(verifycode)) {
            System.out.println("验证码正确" + checkCode_session);
            // 验证码正确
            // 判断用户名和密码是否正确
            if (username != null && password != null) {
                // 调用Service查询
                ControllerServiceImpl controllerService = new ControllerServiceImpl();
                List<Controller> controllerByNameAndPassword = controllerService.findControllerByNameAndPassword(username, password);
                if (controllerByNameAndPassword != null && controllerByNameAndPassword.size() > 0) {
                    for (Controller controller : controllerByNameAndPassword) {
                        if (controller.getName().equals(username) && controller.getPassword().equals(password)) {
                            // success login
                            System.out.println("用戶名密碼正确" + checkCode_session);
                            // 如果成功登陆，那么添加属性user，以便后面做filter
                            session.setAttribute("user", username);
                            response.sendRedirect(request.getContextPath() + "/index.jsp");
                            break;
                        }
                    }

                }

            } else {
                // login fail
                session.setAttribute("login_error", "用户名或者密码错误");
                // forward
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //验证码不一致
            request.setAttribute("login_error", "验证码错误，请重新输入");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
