<%--
  Created by IntelliJ IDEA.
  User: 82432
  Date: 2023/10/25
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        table, td {
            border: 1px solid;
        }
    </style>
</head>
<body>
<h2>首页</h2>
<h3>欢迎您，${sessionScope.user.username}</h3>
<table>
    <tr>
        <td>id</td>
        <td>${sessionScope.user.id}</td>
    </tr>
    <tr>
        <td>账号</td>
        <td>${sessionScope.user.username}</td>
    </tr>
    <tr>
        <td>类型</td>
        <td>${sessionScope.user.usertype}</td>
    </tr>
    <tr>
        <td>电话</td>
        <td>${sessionScope.user.phone}</td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td>${sessionScope.user.email}</td>
    </tr>
</table>
<h4><a href="login?op=loginOut">退出登录</a></h4>
<h5>
    当前在线用户：<c:forEach items="${applicationScope.onLineUsers}" var="username">${username}</c:forEach>
</h5>
</body>
</html>