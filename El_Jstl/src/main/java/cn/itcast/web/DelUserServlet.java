package cn.itcast.web;

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
 * @Date: 2020/03/15 09:25
 */
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DelUserServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");
        //获取被删除id
        int id = Integer.parseInt(request.getParameter("id"));
        logger.info("删除用户的id ==" + id);
        // 调用服务
        ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
        int i = consumerService.delConsumerById(id);
        //重定向
        response.sendRedirect(request.getContextPath() + "/findUsersByPagesServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
