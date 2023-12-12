package listener;

import pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;

@WebListener
public class LoginListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public LoginListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        //通过事件对象获取ServletContext(即jsp里的application对象)
        ServletContext context = sce.getServletContext();
        //创建一个ArrayList用于存储在线用户的用户名
        ArrayList<String> onLineUsers = new ArrayList<>();
        //将ArrayList作为属性存入ServletContext
        context.setAttribute("onLineUsers", onLineUsers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("监听到sessionCreated------session id="+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("监听到sessionCreated------session id="+se.getSession().getId());
        //通过事件对象获取session
        HttpSession session = se.getSession();
        //从session属性中取出用户对像
        User user = (User) session.getAttribute("user");
        //获取ServletContext对象
        ServletContext context = session.getServletContext();
        //从ServletContext对象中属性中 取出onLineUsers
        ArrayList<String> onLineUsers = (ArrayList<String>) context.getAttribute("onLineUsers");
        String username = user.getUsername();
        //将用户从onLineUsers中移除
        onLineUsers.remove(username);
        System.out.println("-------"+ username+ "下线了--------");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        String name = sbe.getName();
        System.out.println("监听到sessionAttributeAdded-----name=" +name);
        if (name.equals("user")) {
            User user = (User)sbe.getValue();
            ServletContext context = sbe.getSession().getServletContext();
            ArrayList<String> onLineUsers = (ArrayList<String>) context.getAttribute("onLineUsers");
            String username = user.getUsername();
            if (!onLineUsers.contains(username)) {
                onLineUsers.add(username);
            }
            System.out.println("-----"+username+"上线了-----");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
