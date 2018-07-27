package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDemo03")
public class ServletDemo03 extends BaseServlet {

/*
    public ServletDemo03(){
        System.out.println("无参构造函数");
    }
*/


    public String addStu(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        System.out.println("添加学生-04");
        return "/test.html";
    }

    public String delStu(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("删除学生-04");
        return "/test.html";
    }

    public String checkUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("检查学生-04");
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
