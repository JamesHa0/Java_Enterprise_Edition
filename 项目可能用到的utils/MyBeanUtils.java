package com.example.web1115;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.*;
import java.util.Set;

public class MyBeanUtils {
    public static <T> T requestToBean(Class<T> cls, HttpServletRequest request) {
        try {
            T obj = cls.getDeclaredConstructor().newInstance();
            //获取参数  ?title=aaaa&content=xxxxxx&xx=yyyy
            Map<String, String[]> paramMap =  request.getParameterMap();
            //遍历Map
            Set<Entry<String, String[]>> set = paramMap.entrySet();

            for (Entry<String, String[]> entry : set) {
                String name = entry.getKey();  //属性名
                String[] value = entry.getValue();
                try {
                    //根据属性名获取setter方法  title----setTitle()
                    String setName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);  //setName = "setTitle";
                    Class<?> type = cls.getDeclaredField(name).getType();  //获取对应的属性的类型
                    // 方法名  参数类型
                    Method method = cls.getDeclaredMethod(setName, type);
                    // obj.setTitle(value);
                    Object val = value[0];
                    // 转型问题：
                    if(type==int.class || type==Integer.class) {
                        val = Integer.parseInt(val.toString());
                    }else if(type==float.class || type==Float.class) {
                        val = Float.parseFloat(val.toString());
                    }
                    //obj.setTitle(value);
                    method.invoke(obj, val);
                }catch (Exception e) {

                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


