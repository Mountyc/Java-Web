package servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//注意需要通过value添加过滤的url路径，/*代表任意路径
@WebFilter(filterName = "ErrorFilter", value = "/*")
public class ErrorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //设置请求和相应的编码为utf-8
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //让过滤器执行
        chain.doFilter(request, response);
    }
}
