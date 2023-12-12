<%--
  Created by IntelliJ IDEA.
  User: 82432
  Date: 2023/9/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <form action="LoginServlet" method ="post">
    <table>
      <tr>
        <td>账号</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="登录"><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form><br>
  <span style="color: red">${loginError}</span>
  </body>

</html>
