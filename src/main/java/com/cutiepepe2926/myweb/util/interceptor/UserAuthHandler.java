package com.cutiepepe2926.myweb.util.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

//인터셉터 클래스로 동작하려면 HandlerInterceptor 를 상속 받음
public class UserAuthHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //true 입력 시 컨트롤러로 넘어감, false 입력 시 컨트롤러 실행x

//        if () {
//            return true;
//        } else {
//            return false;
//        }
        System.out.println("access allow");
        return true;
    }

}
