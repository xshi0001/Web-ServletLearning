package cn.itcast.web;

import cn.itcast.domain.Consumer;
import cn.itcast.service.impl.ConsumerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Consumer consumer = new Consumer();
        try {
            BeanUtils.populate(consumer, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(consumer.toString());
        //4.调用Service保存
        ConsumerServiceImpl consumerService = new ConsumerServiceImpl();

        consumerService.addConsumer(consumer);

        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath() + "/findUsersByPagesServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
