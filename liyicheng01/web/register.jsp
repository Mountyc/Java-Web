<%--
  Created by IntelliJ IDEA.
  User: 82432
  Date: 2023/10/25
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册新用户</h1>
<form method="post" action="RegisterServlet">
    <table>
        <tr>
            <td>账号</td>
            <td><input type="text" name="newUsername"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="newPassword"></td>
        </tr>
        <tr>
            <td>用户类型</td>
            <td>
                <select name="userType">
                    <option value="学生">学生</option>
                    <option value="教师">教师</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
