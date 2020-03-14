<%--
  Created by IntelliJ IDEA.
  User: xshi0
  Date: 2020/3/13
  Time: 15:07
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
    <title>login</title>

    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/session_cookie/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>
</head>
<body>

<form action="/session_cookie/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>

        <tr>
            <td colspan="2"><img id="img" src="/session_cookie/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>

    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error") %>
    </div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %>
    </div>

</form>
</body>
</html>
