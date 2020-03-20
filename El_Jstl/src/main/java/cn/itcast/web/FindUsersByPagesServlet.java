package cn.itcast.web;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.PageBean;
import cn.itcast.service.impl.ConsumerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/15 15:29
 */
@WebServlet("/findUsersByPagesServlet")
public class FindUsersByPagesServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(FindUsersByPagesServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 设置编码
        request.setCharacterEncoding("utf-8");
        // 2 获取前台设置的总的pages以及当前pages请求配置， 总的pages> 当前pages

        int currentPage;
        int rows;

        if (request.getParameter("currentPage") == null || "".equals(request.getParameter("currentPage"))) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        }

        if (request.getParameter("rows") == null || "".equals(request.getParameter("rows"))) {
            rows = 5;
        } else {
            rows = Integer.parseInt(request.getParameter("rows"));
        }
        // 获取查询的条件
        Map<String, String[]> condition = request.getParameterMap();

        logger.info("设置当前的页数为===" + currentPage + "===设置每一页记录数为===" + rows);
        // 3 调用service ，返回每一页的consumers的数据
        ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
        PageBean<Consumer> pb = consumerService.findUseByPages(rows, currentPage, condition);
        // 4 将PageBean存入request
        request.setAttribute("pb", pb);
        // 5 将查询条件存入request 作为页面查询条件回显
        request.setAttribute("condition", condition);
        // 6 转发到list.jsp， 替换userListServlet
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
