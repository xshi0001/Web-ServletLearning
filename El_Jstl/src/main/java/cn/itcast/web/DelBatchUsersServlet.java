package cn.itcast.web;

import cn.itcast.service.impl.ConsumerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/15 13:39
 */
@WebServlet("/delBatchUsersServlet")
public class DelBatchUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码
        request.setCharacterEncoding("utf-8");
        // 2.获取所有的被删除信息的id
        String[] idsArry = request.getParameterValues("uid");
        List<Integer> ids = Arrays.stream(idsArry)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        // 3 调用sevice 批量删除
        ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
        consumerService.delSelectedConsumersByIds(ids);
        // 4 重新定向到用户list
        response.sendRedirect(request.getContextPath() + "/findUsersByPagesServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
