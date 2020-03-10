package com.itheima.servlet.demo;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: maven_tomcat
 * @description: servlet 快速入门-servlet创建，实现接口
 * <p>
 * Servlet的生命周期:从Servlet被创建到Servlet被销毁的过程
 * 一次创建，到处服务，一个Servlet只会有一个对象，服务所有的请求
 *
 * 	* Servlet中的生命周期方法：
 * 		1. 被创建：执行init方法，只执行一次
 * 			* Servlet什么时候被创建？
 * 				* 默认情况下，第一次被访问时，Servlet被创建
 * 				* 可以配置执行Servlet的创建时机。
 * 					* 在<servlet>标签下配置
 * 						1. 第一次被访问时，创建
 * 	                		* <load-on-startup>的值为负数
 * 			            2. 在服务器启动时，创建
 * 			                * <load-on-startup>的值为0或正整数
 *
 *
 * 			* Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
 * 				* 多个用户同时访问时，可能存在线程安全问题。
 * 				* 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值
 *
 * 		2. 提供服务：执行service方法，执行多次
 * 			* 每次访问Servlet时，Service方法都会被调用一次。
 * 		3. 被销毁：执行destroy方法，只执行一次
 * 			* Servlet被销毁时执行。服务器关闭时，Servlet被销毁
 * 			* 只有服务器正常关闭时，才会执行destroy方法。
 * 			* destroy方法在Servlet被销毁之前执行，一般用于释放资源
 *
 *
 *
 * @author: JClearLove
 * @Date: 2020/03/09 20:49
 */
public class ServletDemo implements Servlet {

    /**
     * 生命周期方法:当Servlet第一次被创建对象时执行该方法,该方法在整个生命周期中只执行一次
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
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("Hello Servlet,service。。。");

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

