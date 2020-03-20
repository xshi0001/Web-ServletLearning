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

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/15 11:56
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 设置编码
        request.setCharacterEncoding("utf-8");
        // 2 获取参数map
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 3 封装对象
        Consumer consumer = new Consumer();
        try {
            BeanUtils.populate(consumer, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 4 调用update service
        ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
        consumerService.updateConsumerById(consumer);
        // 5 重定向页面
        response.sendRedirect(request.getContextPath()+"/findUsersByPagesServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
