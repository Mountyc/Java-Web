package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //测试get方式访问
        response.setContentType("text/html");
        response.getWriter().println("通过get访问LoginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("")||password.equals("")){
            request.setAttribute("loginError", "账号或密码为空");
            //利用请求转发到index.jsp
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //获取session
            HttpSession session = request.getSession();
            //利用session 的属性来传递参数，在整个会话期间都可以访问
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            //利用响应重定向到main.jsp
            response.sendRedirect("main.jsp");
        }
    }
}
