package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String md = request.getParameter("method");
        System.out.println("获取md-Base");
        System.out.println(md);
        String path = null;

        Class clazz = this.getClass();

        try {
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            if (null != method) {
                path = (String) method.invoke(this, request, response);
            }

            if (null != path) {
                request.getRequestDispatcher(path).forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
