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

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/15 10:42
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(FindUserServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取被修改信息用户id
        String userId = request.getParameter("id");
        //3.调用更新用户信息sevive
        ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
        Consumer consumer = consumerService.findConsumerById(Integer.parseInt(userId));
        logger.info("findUserServlet===id " + userId + "===" + consumer.toString());
        //4.将user存入request中，注意是requestScope 不是sessionScope
        request.setAttribute("user", consumer);
        //5.转发到update.jsp 共享request对象的属性
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

