package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    <!--   <servlet>
           <description>This is the description of my J2EE component</description>
           <display-name>This is the display name of my J2EE component</display-name>
           <servlet-name>AsynServlet</servlet-name>
           <servlet-class>com.itheima.servlet.AsynServlet</servlet-class>
           <async-supported>true</async-supported>
       </servlet>

       <servlet-mapping>
           <servlet-name>AsynServlet</servlet-name>
           <url-pattern>/servlet/AsynServlet</url-pattern>
       </servlet-mapping>-->
*/


@WebServlet(urlPatterns = "/servlet/AsynServlet", asyncSupported = true)
public class AsynServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public AsynServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Servlet执行开始时间:" + new Date());
        AsyncContext context = request.startAsync();
        new Thread(new Executor(context)).start();
        System.out.println("Servlet执行结束时间:" + new Date());
    }

    public class Executor implements Runnable {
        private AsyncContext context;

        public Executor(AsyncContext context) {
            this.context = context;
        }

        @Override
        public void run() {
            //复杂业务
            try {
                Thread.sleep(1000 * 10);
//				context.getRequest();
//				context.getResponse();
                System.out.println("业务执行完成时间:" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        // Put your code here
    }

}
