package com.jameshao.demo1114.servlet;

import com.alibaba.fastjson2.JSON;
import com.jameshao.demo1114.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/login")
public class LoginServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        boolean isLogin = false;
//        Cookie[] cookieArr = request.getCookies();
//        if( cookieArr != null){
//            // 遍历
//            for(Cookie c : cookieArr){
//                if(c.getName().equals("user")){
//                    System.out.println("自动登录...");
//                    isLogin = true;
//                }
//            }
//        }
//        if(!isLogin){

        response.setHeader("Access-Control-Allow-Credentials", "true");
        //response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        System.out.println("sessionId:" + session.getId());

        //1.取
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //2.调
            LoginServiceImpl service = new LoginServiceImpl();
            int result = service.login(username, password);
//            //返回JSON
//            response.getWriter().println(JSON.toJSONString(result) );
            if(result == 1) {
                System.out.println("登录成功");
                //向session中保存登录信息
                session.setAttribute("user", username);
                out.println("OK");
            } else {
                out.println("error");
//                //创建登录成功的信息（用户信息）Cookie
//                Cookie userCookie = new Cookie("user",username);
//                //设置Cookie有效期
//                userCookie.setMaxAge(60*3);//3小时
//                //向客户端发送Cookie
//                response.addCookie(userCookie);
            }
        out.close();
//        }


    }
}
