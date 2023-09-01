package com.youtube.blog.config;

import com.youtube.blog.beans.FirstBean;
import com.youtube.blog.beans.ThirdBean;
import com.youtube.blog.beans.ThirdBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public FirstBean firstBean(){
        return new FirstBean();
    }

    @Bean
    public FirstBean secondBean(){
        return new FirstBean("Zhako",18);
    }

    @Bean
    public ThirdBean thirdBean(){
        return new ThirdBeanImpl();
    }
}
