package servlet;

import dao.UserDao;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");

        if (newUsername.equals("") || newPassword.equals("")) {
            // 注册失败，利用request属性传递错误信息
            request.setAttribute("registerError", "用户名或密码不能为空");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            // 创建User对象并设置用户名和密码
            User newUser = new User();
            newUser.setUsername(newUsername);
            newUser.setPassword(newPassword);

            // 创建UserDao对象并调用方法将新用户信息保存到数据库中
            UserDao userDao = new UserDao();
            try {
                userDao.addUser(newUser); // 假设有一个名为addUser的方法来向数据库中添加用户
            } catch (SQLException e) {
                // 处理可能的SQL异常
                e.printStackTrace();
            }

            // 注册成功后，重定向到登录页面
            response.sendRedirect("index.jsp");
        }
    }
}