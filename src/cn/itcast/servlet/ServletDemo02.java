package cn.itcast.servlet;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

//@WebServlet(name = "ServletDemo02")
public class ServletDemo02 extends HttpServlet {

    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String md = request.getParameter("method");
        System.out.println("获取md");
        System.out.println(md);
        String path = null;

        Class clazz = this.getClass();

        try {
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            System.out.println(method);
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

    public String addStu(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        System.out.println("添加学生-03");
        return "/test.html";
    }

    public String delStu(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("删除学生-03");
        return "/test.html";
    }

    public String checkUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("检查学生-03");
        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题
        String jsonStr = "{\"id\":\"123\",\"name\":\"小黎\"}";
        PrintWriter out = null;
        out = response.getWriter();
        out.write(jsonStr);
        out.close();

//        response.getWriter().println("22222D");
        return null;
    }


}
