package com.jameshao.demo1114.service;

public class LoginServiceImpl {
    public int login(String username,String password){
        //验证
        if("admin".equals(username) && "123456".equals(password)){
            return 1;
        }else {
            return -1;
        }
    }
}
