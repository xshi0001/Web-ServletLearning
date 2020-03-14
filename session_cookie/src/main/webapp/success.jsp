<%--
  Created by IntelliJ IDEA.
  User: xshi0
  Date: 2020/3/13
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
</body>
</html>
