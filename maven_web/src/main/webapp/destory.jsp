<%--
  Created by IntelliJ IDEA.
  User: xshi0
  Date: 2020/3/10
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";

    request.removeAttribute("requestName");
    request.getSession().removeAttribute("requestName");
    request.getSession().getServletContext().removeAttribute("requestName"");
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp, this a page to be destoryed</title>
</head>
<body>
<h1>new jsp</h1>
<button onclick="Location.href='<%=request.getContextPath()%>/init.jsp'">init</button>
<button onclick="Location.href='<%=request.getContextPath()%>/destory.jsp'">destory</button>
</body>
</html>
