package com.jameshao.demo1114.servlet;

import com.alibaba.fastjson2.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //设置允许跨域访问，并且设置允许什么样的url进行跨域访问。
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/JSON;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        String[] username = request.getParameterValues("username");
        System.out.println(Arrays.toString(username));

        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("World");
        list.add("!!!");

        PrintWriter out = response.getWriter();
        out.println( JSON.toJSONString(list) );
        out.close();
    }

}