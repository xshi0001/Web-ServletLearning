package com.itheima.servlet.create;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @program: maven_tomcat
 * @description: servlet 快速入门-servlet创建，实现接口
 * <p>
 * 什么是servler生命周期？分为几个阶段？ 容器实例化 ----》初始化init-----》就绪调用service --->销毁 destory
 * <p>
 * <p>
 * <p>
 * Servlet的生命周期:从Servlet被创建到Servlet被销毁的过程
 * 一次创建，到处服务，一个Servlet只会有一个对象，服务所有的请求
 * <p>
 * * Servlet中的生命周期方法：
 * 1. 被创建：执行init方法，只执行一次
 * * Servlet什么时候被创建？
 * * 默认情况下，第一次被访问时，Servlet被创建
 * * 可以配置执行Servlet的创建时机。
 * * 在<servlet>标签下配置
 * 1. 第一次被访问时，创建
 * * <load-on-startup>的值为负数
 * 2. 在服务器启动时，创建
 * * <load-on-startup>的值为0或正整数
 * <p>
 * <p>
 * * Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
 * * 多个用户同时访问时，可能存在线程安全问题。
 * * 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值
 * <p>
 * 2. 提供服务：执行service方法，执行多次
 * * 每次访问Servlet时，Service方法都会被调用一次。
 * 3. 被销毁：执行destroy方法，只执行一次
 * * Servlet被销毁时执行。服务器关闭时，Servlet被销毁
 * * 只有服务器正常关闭时，才会执行destroy方法。
 * * destroy方法在Servlet被销毁之前执行，一般用于释放资源
 * @author: JClearLove
 * @Date: 2020/03/09 20:49
 */
@WebServlet(urlPatterns = "/createServletByImplementServlet")
public class CreateServletByImplementServlet implements Servlet {

    /**
     * 生命周期方法:当Servlet第一次被创建对象时执行该方法,该方法在整个生命周期中只执行一次
     * <p>
     * 当用户调用一个 Servlet 时，就会创建一个 Servlet 实例，每一个用户请求都会产生一个新的线程，
     * 适当的时候移交给 doGet 或 doPost 方法。init()
     * 方法简单地创建或加载一些数据，这些数据将被用于 Servlet 的整个生命周期。
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("=======init=========");

    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 生命周期方法:对客户端响应的方法,该方法会被执行多次，每次请求该servlet都会执行该方法
     * <p>
     * 调用 com.itheima.service() 方法来处理来自客户端（浏览器）的请求，并把格式化的响应写回给客户端
     * <p>
     * service方法由容器调用，service方法在适当的时候调用 doGet、doPost、doPut、doDelete 等方法。所以，您不用对 com.itheima.service() 方法做任何动作，您只需要根据来自客户端的请求类型来重写 doGet() 或 doPost() 即可。
     * <p>
     * doGet() 和 doPost() 方法是每次服务请求中最常用的方法。下面是这两种方法的特征。
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("Hello Servlet,com.itheima.service。。。");

    }

    /**
     * 获取Servlet的一些信息，版本，作者等等。
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 生命周期方法:当Servlet被销毁时执行该方法
     * 当停止tomcat时也就销毁的servlet。
     */
    @Override
    public void destroy() {
        System.out.println("******destroy**********");
    }
}

