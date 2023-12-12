<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      text-align: center;
      margin-top: 100px;
    }
    form {
      display: inline-block;
      border: 1px solid #ccc;
      padding: 20px;
      background-color: #fff;
    }
    table {
      margin: 0 auto;
    }
    input[type="text"],
    input[type="password"] {
      width: 200px;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ddd;
    }
    input[type="submit"],
    input[type="reset"] {
      padding: 10px 20px;
      margin-top: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
    }
    input[type="submit"]:hover,
    input[type="reset"]:hover {
      background-color: #45a049;
    }
    span {
      display: block;
      margin-top: 10px;
      color: red;
    }
  </style>
</head>
<body>
<script type="text/javascript">
  function check() {
    let username = document.forms[0].username.value;
    let password = document.forms[0].password.value;
    if (username === '') {
      alert("账号不能为空");
      return false;
    }
    if (password === '') {
      alert("密码不能为空");
      return false;
    }
    return true;
  }
</script>
<form action="login" method="post" onsubmit="return check()">
  <table style="border: 1px solid black;">
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
</form>
<span style="color: red">${loginError}</span>
<a href="register.jsp">注册新用户</a>
</body>
</html>