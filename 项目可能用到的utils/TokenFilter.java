package com.hxy.his.utils;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hxy.his.vo.Result;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/*")
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request  = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "token");
        response.setHeader("Access-Control-Expose-Headers", "token");

        response.setCharacterEncoding("UTF-8");
        // 对OPTIONS请求方法的请求进行处理
        String method = request.getMethod();
        if(method.toUpperCase().equals("OPTIONS")){
            //是options请求方法
            response.setStatus(HttpServletResponse.SC_OK);
        }


        String uri = request.getRequestURI();
        System.out.println("TokenFilter过滤器拦截了："+uri);
        if(uri.indexOf("login")!=-1 || uri.indexOf(".jpg")!=-1 || uri.indexOf(".png")!=-1){
            System.out.println("是login请求或者jpg或者png，放行");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            String token = request.getHeader("token");
            if(token==null){
                System.out.println("没有token，返回错误信息");
                //code=50001 没有携带token
                Result r = new Result(50001,"无token",null);
                response.getWriter().println(JSON.toJSONString(r));
            }else{
                try {
                    DecodedJWT verify = JWTUtils.verify(token);
                    System.out.println("token没问题，放行");
                    filterChain.doFilter(servletRequest,servletResponse);
                }catch (Exception e){
                    System.out.println("token无效，返回错误信息");
                    //token无效 code=50002
                    Result r = new Result(50002,"token无效",null);
                    response.getWriter().println(JSON.toJSONString(r));
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
