# maven_tomcat


## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Important concepts and classes](#important-concepts-and-classes)
<!--* [Directory Structure](#directory-structure)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [References & Future Resources](#references-&-future-resources)-->


## General info
Servlet（Server Applet），全称Java Servlet，未有中文译文。是用Java编写的服务器端程序。其主要功能**在于交互式地浏览和修改数据，生成动态Web内容**。狭义的Servlet是指Java语言实现的一个接口，广义的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为后者。
Servlet运行于支持Java的应用服务器中。从实现上讲，Servlet可以响应任何类型的请求，但绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器。
最早支持Servlet标准的是JavaSoft的Java Web Server。此后，一些其它的基于Java的Web服务器开始支持标准的Servlet。

**Keywords ：**  web动态资源;Servlet 3;组件与容器;

<!--动态资源:每个用户访问相同资源后，得到的结果可能不一样。称为动态资源。动态资源被访问后，需要先转换为静态资源，在返回给浏览器-->
<!--常用的动态资源框架* 如：servlet/jsp,php,asp....-->
## Screenshots

![image_1](https://o7planning.org/en/10169/cache/images/i/788727.png)

## Technologies
* Servlet 3.1 Web.xml3.1
* JDK8 JavaEE <!--当前版本是7，正在进行8版本的开发。Servlet 是Java EE下的框架，不再JavaSE中。-->
* Tomcat8

## Important concepts and classes
*Important concepts:*
* Servlet
* Filter
* [listener](https://www.imooc.com/learn/271)
<!--  监听器种类按照监听对象划分：
- 用于监听应用程序环境对象的事件- ServletContext
- 用于监听用户对话对象的事件 - HttpSession
- 用于监听请求消息对象的事件 - ServletRequest-->

<!--  监听器种类按照监听事件划分：
- 域对象自身的创建和销毁事件
- 域对象中的属性增加与删除事件
- 绑定到HttpSession域中的某一个对象状态事件-->

*classes:*
* HttpServlet
* ServetConfig
* ServletContext
* Filter
* FilterConfig
* FilterChain
* RequestDispatcher
* HttpServletRequest
* HttpServletResponse
* HttpSession
<!--Java Web 项目还需要一个非常重要的配置文件 web.xml ，每个
<!--servlet 都必须在 web.xml 中定义并进行 URL 映射配置.加载顺序： *content-param -- --
<!--listener -- filter --servlet*通过查看3.0版本的xsd可以看到大概有以下一级节点：-->







## References & Future Resources
- [Java EE 7 API文档](https://docs.oracle.com/javaee/7/api/toc.htm)
- [JSR 366: Java Platform, Enterprise Edition 8 (Java EE 8) Specification](https://jcp.org/en/jsr/detail?id=366)
- [Servlet 4 官方文档](https://jcp.org/en/jsr/detail?id=369)
- [Java Servlet完全教程](http://www.importnew.com/14621.html)
- [Servlet 工作原理解析](https://www.ibm.com/developerworks/cn/java/j-lo-servlet/)
- [Servlet 3.0 介绍](http://www.oschina.net/question/12_8793)
- [Servlet 4.0 草案](http://www.oschina.net/news/54158/servlet_4_0)
- [Servlet的历史与规范](http://blog.csdn.net/u010297957/article/details/51498018)
- [红薯:初学 Java Web 开发，请远离各种框架，从 Servlet 开发](http://www.oschina.net/question/12_52027?sort=default&p=2#)
- [Servlet 3.0 新特性详解](http://www.ibm.com/developerworks/cn/java/j-lo-servlet30/)
- [JSR-000315 Java Servlet 3.0 规范](http://jcp.org/aboutJava/communityprocess/final/jsr315/index.html)
- [Web.xml详解](http://blog.csdn.net/believejava/article/details/43229361)
- [IDEA+Maven+JavaWeb+tomcat项目搭建](https://blog.csdn.net/weixin_33446857/article/details/82143258?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)
- [初学 Java Web 开发，请远离各种框架，从 Servlet 开发](https://www.oschina.net/question/12_52027?sort=default&p=2#)
- [Servlet-cheat sheet](https://github.com/upan/cheat-sheet/wiki/Servlet)
