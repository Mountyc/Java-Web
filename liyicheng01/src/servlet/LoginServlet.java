package servlet;

import dao.UserDao;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用 doGet 方法实现用户退出登录，用户通过超链接访问 /login?op=loginOut 则视为退出登录
        // op 为参数名，值为 loginOut
        String op = request.getParameter("op");
        if (op != null && op.equals("loginOut")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String loginInfo = ""; // 初始化登录信息字符串
        // 创建 UserDao 实例
        UserDao userDao = new UserDao();
        try {
            // 调用 UserDao 查询数据库
            User user = userDao.getUserByUsernameAndPassword(username, password);
            if (user == null) {
                loginInfo = "账号或密码错误";
                request.setAttribute("loginError", loginInfo);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                // 登录成功
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}