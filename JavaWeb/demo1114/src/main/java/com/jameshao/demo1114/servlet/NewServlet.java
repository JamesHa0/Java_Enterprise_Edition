package com.jameshao.demo1114.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/new")
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从request作用域中获取属性值
        System.out.println(req.getAttribute("message"));
        //从Session作用域中获取属性值
        System.out.println(req.getSession().getAttribute("message"));
        //从ServletContext作用域中获取属性值
        System.out.println(req.getServletContext().getAttribute("message"));
    }
}
