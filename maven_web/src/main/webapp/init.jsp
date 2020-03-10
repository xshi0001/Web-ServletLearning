<%--
  Created by IntelliJ IDEA.
  User: xshi0
  Date: 2020/3/10
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";

    request.setAttribute("requestName", "requestName");
    request.getSession().setAttribute("requestName", "requestName");
    request.getSession().getServletContext().setAttribute("requestName", "requestName");

%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp</title>
</head>
<body>
<h1>new jsp,this is the initialization interface</h1>
<button onclick="Location.href='<%=request.getContextPath()%>/init.jsp'">init</button>
<button onclick="Location.href='<%=request.getContextPath()%>/destory.jsp'">destory</button>
</body>
</html>
