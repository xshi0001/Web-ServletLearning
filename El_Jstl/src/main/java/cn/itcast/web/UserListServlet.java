package cn.itcast.web;

import cn.itcast.domain.Consumer;
import cn.itcast.service.impl.ConsumerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(UserListServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        ConsumerServiceImpl service = new ConsumerServiceImpl();
        List<Consumer> consumers = service.selectAll();
        //2.将list存入request域
        logger.info(String.format("用户信息列表共查询到====%s====", consumers.size()));
        request.setAttribute("consumers", consumers);
        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
