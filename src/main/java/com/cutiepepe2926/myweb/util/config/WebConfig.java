package com.cutiepepe2926.myweb.util.config;

import com.cutiepepe2926.myweb.util.interceptor.UserAuthHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 스프링에 빈으로 등록
    @Bean
    public UserAuthHandler userAuthHandler(){
        return new UserAuthHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthHandler()) //실행시킬 인터셉터 클래스 등록
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/logout")
                .excludePathPatterns("/user/join")
                .addPathPatterns("/**");
    }


    // 여러 인터셉트를 다른 경로별로 동작시키려면 하나 더 만드면 된다.


}
