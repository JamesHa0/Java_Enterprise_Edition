package com.jameshao.demo1114.servlet;

import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("访问了FirstServlet");
        List<String> data = new ArrayList<>();
        data.add("Hallo...");
        data.add("xxx...");

        PrintWriter out = resp.getWriter();
        out.println(JSON.toJSONString(data));
        out.close();

//        // 向Request作用域中添加属性
//        req.setAttribute("message","Message信息");
//
//        //向Session作用域中添加属性
//        req.getSession().setAttribute("message","session信息");
//
//        //向ServletContext作用域中添加属性
//        req.getServletContext().setAttribute("message","servletcontext信息");




    }
}
