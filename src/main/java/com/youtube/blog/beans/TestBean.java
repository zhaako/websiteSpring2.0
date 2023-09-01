package com.youtube.blog.beans;


import org.springframework.stereotype.Component;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Component
public class TestBean {
    private String text = "Hello";
    public TestBean(){
        System.out.println("Creating Test Bean");
    }

    public void SetText(String text){
        this.text = text;
    }

    public String getData(){
        return "This is " + this.text + " data";
    }
}
